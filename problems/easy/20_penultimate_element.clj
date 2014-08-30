; Write a function which returns the second to last element from a sequence.
; http://www.4clojure.com/problem/20

; (= (__ (list 1 2 3 4 5)) 4)
; (= (__ ["a" "b" "c"]) "b")
; (= (__ [[1 2] [3 4]]) [1 2])

#(-> % reverse second)