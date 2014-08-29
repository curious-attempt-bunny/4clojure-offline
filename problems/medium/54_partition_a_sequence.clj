; Write a function which returns a sequence of lists of x items each.  Lists of less than x items should not be returned.
; http://www.4clojure.com/problem/54
; Don't use: partition, nor partition-all

; (= (__ 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8)))
; (= (__ 2 (range 8)) '((0 1) (2 3) (4 5) (6 7)))
; (= (__ 3 (range 8)) '((0 1 2) (3 4 5)))

(fn part [n coll]
	(if (< (count coll) n)
		[]
		(cons (take n coll) (part n (drop n coll)))))