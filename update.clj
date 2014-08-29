(defn insert! [type problem]
	(if (true? (:approved problem))
			(do
				(let [difficulty (first (:tags problem))
							directory  (str "problems/" difficulty)
							id         (format "%02d" (:_id problem))
							filename   (str id "_" (:title problem))
							path       (str directory "/" filename)
							url        (str "http://www.4clojure.com/problem/" (:_id problem))
							contents   (concat [(str "; " (:description problem))]
																 [(str "; " url)]
																 [""]
																 (map #(str "; " (clojure.string/replace % #"\n" " ") ) (:tests problem))
																 [""]
																 [""])]
							(.mkdir (java.io.File. directory))
							(if-not (.exists (clojure.java.io/file path))
								(spit path (clojure.string/join "\n" contents)))
				))))
(eval (read-string (clojure.string/join "\n" (drop 3 (clojure.string/split (slurp "data_set.clj") #"\n")))))
(.mkdir (java.io.File. "problems"))
(load-problems)