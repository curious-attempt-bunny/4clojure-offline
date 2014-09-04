; Write a function which returns the intersection of two sets.  The intersection is the sub-set of items that each set has in common.
; http://www.4clojure.com/problem/81
; Don't use: intersection

; (= (__ #{0 1 2 3} #{2 3 4 5}) #{2 3})
; (= (__ #{0 1 2} #{3 4 5}) #{})
; (= (__ #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d})

(fn [coll1 coll2] (set (filter #(and (contains? coll1 %) (contains? coll2 %)) (concat coll1 coll2))))