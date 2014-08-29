(defn directory [problem] (str "problems/" (first (:tags problem))))

(defn path [problem]
	(let [id         (format "%02d" (:_id problem))
				identifier (clojure.string/replace (clojure.string/lower-case (:title problem)) #"[^a-z]+" "_")
				filename   (str id "_" identifier ".clj")]
			 (str (directory problem) "/" filename)))
(defn url [problem] (str "http://www.4clojure.com/problem/" (:_id problem)))

(defn base-content [problem]
	(concat [(str "; " (:description problem))]
					[(str "; " (url problem))]
					(if (:restricted problem)
							 [(str "; Don't use: " (clojure.string/join ", nor " (:restricted problem)))]
							 [])
					[""]
					(map #(str "; " (clojure.string/replace % #"\n" " ") ) (:tests problem))
					[""]
					[""]))

(defn test-problem [problem]
	; TODO
	)

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

(.mkdir (java.io.File. "problems"))
(eval (read-string (clojure.string/join "\n" (drop 3 (clojure.string/split (slurp "data_set.clj") #"\n")))))
(load-problems)