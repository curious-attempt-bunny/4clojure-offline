(.mkdir (java.io.File. "problems"))

(defn directory [problem] (str "problems/" (first (:tags problem))))

(defn path [problem]
	(let [id         (format "%02d" (:_id problem))
				identifier (clojure.string/replace (clojure.string/lower-case (:title problem)) #"[^a-z]+" "_")
				filename   (str id "_" identifier ".clj")]
			 (str (directory problem) "/" filename)))
(defn url [problem] (str "http://www.4clojure.com/problem/" (:_id problem)))

(defn base-content [problem]
	(concat [(str "; " (clojure.string/replace (:description problem) #"</?[a-z]+/?>|\n" ""))]
					[(str "; " (url problem))]
					(if (:restricted problem)
							 [(str "; Don't use: " (clojure.string/join ", nor " (:restricted problem)))]
							 [])
					[""]
					(map #(str "; " (replace % #"\n" " ") ) (:tests problem))
					[""]
					[""]))

(defn test-expression [solution test]
	(let [code         (clojure.string/replace test "__" solution)
		    form         (read-string code)
		    result       (eval form)
		    inspectcode  (clojure.string/replace test "__" "(throw (Exception. \"correct clause!\"))")
		    subtitutionindex (try (do
		    												(eval (second (read-string inspectcode)))
		    												2)
		    											(catch Exception e (if (= "correct clause!" (.getMessage e))
		    																						 1
		    																						 2)))
		    intermediary (eval (nth form subtitutionindex))]
		{:success (true? result) :test test :intermediary intermediary}))

(spit "problems/state.csv" "" :append true)

(def problem-hashes-evaluated
	(let [csv (filter #(> (count %) 1) (map #(clojure.string/split % #",") (clojure.string/split (slurp "problems/state.csv") #"\n")))]
		(reduce #(assoc %1 (Integer/parseInt (first %2)) (Integer/parseInt (second %2))) {} csv)))

(defn append-result [id hash success] (spit "problems/state.csv" (str id "," hash "," success "\n") :append true))

(defn test-problem [problem]
	(let [lines     (clojure.string/split-lines (slurp (path problem)))
				solution  (clojure.string/trim (clojure.string/join "\n" (filter #(not= (first %) \;) lines)))]
		(if-not (clojure.string/blank? solution)
			(if-not (= (hash solution) (problem-hashes-evaluated (:_id problem)))
				(let [results (map #(test-expression solution %) (:tests problem))
							success (every? #(:success %) results)]
					(append-result (:_id problem) (hash solution) success)
					(print (str "#" (:_id problem) " - " (:title problem) ": "))
					(if success
						(println "complete!")
						(do
							(println)
							(doseq [result results]
								(prn (:test result))
								(print " => ")
								(prn (:intermediary result))
								(println)))))))))

(defn write-problem [problem]
	(spit (path problem) (clojure.string/join "\n" (base-content problem))))

(defn insert! [type problem]
	(if (true? (:approved problem))
			(do
				(.mkdir (java.io.File. (directory problem)))
				(if (.exists (clojure.java.io/file (path problem)))
					(test-problem problem)
					(write-problem problem)
				))))

(eval (read-string (clojure.string/join "\n" (drop 3 (clojure.string/split (slurp "data_set.clj") #"\n")))))

(load-problems)
