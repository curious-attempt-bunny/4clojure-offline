(defn directory [problem] (str "problems/" (first (:tags problem))))

(defn insert! [type problem]
	(if (true? (:approved problem))
			(do
				(let [id         (format "%02d" (:_id problem))
							identifier (clojure.string/replace (clojure.string/lower-case (:title problem)) #"[^a-z]+" "_")
							filename   (str id "_" identifier ".clj")
							path       (str (directory problem) "/" filename)
							url        (str "http://www.4clojure.com/problem/" (:_id problem))
							contents   (concat [(str "; " (:description problem))]
																 [(str "; " url)]
																 (if (:restricted problem)
																 		 [(str "; Don't use: " (clojure.string/join ", nor " (:restricted problem)))]
																 		 [])
																 [""]
																 (map #(str "; " (clojure.string/replace % #"\n" " ") ) (:tests problem))
																 [""]
																 [""])]
							(.mkdir (java.io.File. (directory problem)))
							(if-not (.exists (clojure.java.io/file path))
								(spit path (clojure.string/join "\n" contents)))
				))))
(eval (read-string (clojure.string/join "\n" (drop 3 (clojure.string/split (slurp "data_set.clj") #"\n")))))
(.mkdir (java.io.File. "problems"))
(load-problems)