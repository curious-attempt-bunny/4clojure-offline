; Write a function which removes the duplicates from a sequence. Order of the items must be maintained.
; http://www.4clojure.com/problem/56
; Don't use: distinct

; (= (__ [1 2 1 3 1 2 4]) [1 2 3 4])
; (= (__ [:a :a :b :b :c :c]) [:a :b :c])
; (= (__ '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3]))

reduce (fn [coll x] (if (some #(= % x) coll) coll (conj coll x))) []
