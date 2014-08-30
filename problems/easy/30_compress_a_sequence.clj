; Write a function which removes consecutive duplicates from a sequence.
; http://www.4clojure.com/problem/30

; (= (apply str (__ "Leeeeeerrroyyy")) "Leroy")
; (= (__ [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
; (= (__ [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))

reduce (fn [result elem] (if (= (last result) elem) result (conj result elem))) []