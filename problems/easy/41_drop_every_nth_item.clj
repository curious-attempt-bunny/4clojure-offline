; Write a function which drops every Nth item from a sequence.
; http://www.4clojure.com/problem/41

; (= (__ [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
; (= (__ [:a :b :c :d :e :f] 2) [:a :c :e])
; (= (__ [1 2 3 4 5 6] 4) [1 2 3 5 6])

(fn drop-nth [coll n]
	(if (empty? coll)
		coll
		(lazy-cat (take (dec n) coll) (drop-nth (drop n coll) n))))