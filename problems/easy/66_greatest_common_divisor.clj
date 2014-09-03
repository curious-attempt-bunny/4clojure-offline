; Given two integers, write a function whichreturns the greatest common divisor.
; http://www.4clojure.com/problem/66

; (= (__ 2 4) 2)
; (= (__ 10 5) 5)
; (= (__ 5 7) 1)
; (= (__ 1023 858) 33)

(fn [x y]
	(loop [gcd (min x y)]
		(if (and
					(zero? (rem x gcd))
					(zero? (rem y gcd)))
			gcd
			(recur (dec gcd)))))