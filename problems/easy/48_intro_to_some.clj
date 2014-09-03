; The some function takes a predicate function and a collection.  It returns the first logical true value of (predicate x) where x is an item in the collection.
; http://www.4clojure.com/problem/48

; (= __ (some #{2 7 6} [5 6 7 8]))
; (= __ (some #(when (even? %) %) [5 6 7 8]))

6