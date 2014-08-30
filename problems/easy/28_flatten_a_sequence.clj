; Write a function which flattens a sequence.
; http://www.4clojure.com/problem/28
; Don't use: flatten

; (= (__ '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
; (= (__ ["a" ["b"] "c"]) '("a" "b" "c"))
; (= (__ '((((:a))))) '(:a))

(fn flat [coll]
	(reduce
		(fn [result elem] 
			(if (coll? elem)
			  (vec (concat result (flat elem)))
				(conj result elem)))
	 	[] coll))