(let [lines     (clojure.string/split-lines (slurp "problem.clj"))
			separator (.indexOf lines "")
			tests     (take separator lines)
			solution  (clojure.string/join "\n" (drop (inc separator) lines))]
	(doseq [test tests]
		(let [code         (clojure.string/replace test "__" solution)
			    form         (read-string code)
			    result       (eval form)
			    intermediary (eval (second form))]
			(prn test)
			(print "=> ")
			(prn intermediary)
			(prn result)
			(println))))