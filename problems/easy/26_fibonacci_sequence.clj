; Write a function which returns the first X fibonacci numbers.
; http://www.4clojure.com/problem/26

; (= (__ 3) '(1 1 2))
; (= (__ 6) '(1 1 2 3 5 8))
; (= (__ 8) '(1 1 2 3 5 8 13 21))

#(loop [n (- % 2) result '(1 1)]
	(if (> n 0)
		(recur (dec n) (conj result (reduce + (take 2 result))))
		(reverse result)))
