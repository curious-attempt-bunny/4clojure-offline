(let [lines     (clojure.string/split-lines (slurp "problem.clj"))
			separator (.indexOf lines "")
			tests     (take separator lines)
			solution  (clojure.string/join "\n" (drop (inc separator) lines))]
	(doseq [test tests]
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
			(prn test)
			(print "=> ")
			(prn intermediary)
			(prn result)
			(println))))