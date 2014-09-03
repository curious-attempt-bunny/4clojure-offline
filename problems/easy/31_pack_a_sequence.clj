; Write a function which packs consecutive duplicates into sub-lists.
; http://www.4clojure.com/problem/31

; (= (__ [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))
; (= (__ [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))
; (= (__ [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))

reduce (fn [result elem]
	(let [current (last result)
		 		past    (vec (butlast result))]
		(if (= (first current) elem)
			(conj past (conj current elem))
			(conj result (list elem)))))
	[]
	