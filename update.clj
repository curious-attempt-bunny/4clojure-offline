(use 'clojure.string)

(defn directory [problem] (str "problems/" (first (:tags problem))))

(defn path [problem]
	(let [id         (format "%02d" (:_id problem))
				identifier (replace (lower-case (:title problem)) #"[^a-z]+" "_")
				filename   (str id "_" identifier ".clj")]
			 (str (directory problem) "/" filename)))
(defn url [problem] (str "http://www.4clojure.com/problem/" (:_id problem)))

(defn base-content [problem]
	(concat [(str "; " (replace (:description problem) #"</?[a-z]+/?>|\n" ""))]
					[(str "; " (url problem))]
					(if (:restricted problem)
							 [(str "; Don't use: " (join ", nor " (:restricted problem)))]
							 [])
					[""]
					(map #(str "; " (replace % #"\n" " ") ) (:tests problem))
					[""]
					[""]))

(defn test-problem [problem]
	(let [lines     (split-lines (slurp (path problem)))
				solution  (trim (join "\n" (filter #(not= (first %) \;) lines)))]
		(if-not (blank? solution)
			(do 
				(println (path problem))
				(doseq [test (:tests problem)]
					(let [code         (replace test "__" solution)
						    form         (read-string code)
						    result       (eval form)
						    inspectcode  (replace test "__" "(throw (Exception. \"correct clause!\"))")
						    subtitutionindex (try (do
						    												(eval (second (read-string inspectcode)))
						    												2)
						    											(catch Exception e (if (= "correct clause!" (.getMessage e))
						    																						 1
						    																						 2)))
						    intermediary (eval (nth form subtitutionindex))]

						(prn solution)
						(prn test)
						(print "=> ")
						(prn intermediary)
						(prn result)
						(println)))))))

(defn write-problem [problem]
	(spit (path problem) (join "\n" (base-content problem))))

(defn insert! [type problem]
	(if (true? (:approved problem))
			(do
				(.mkdir (java.io.File. (directory problem)))
				(if (.exists (clojure.java.io/file (path problem)))
					(test-problem problem)
					(write-problem problem)
				))))

(.mkdir (java.io.File. "problems"))
(eval (read-string (join "\n" (drop 3 (split (slurp "data_set.clj") #"\n")))))
(load-problems)
