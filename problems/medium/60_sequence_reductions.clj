; Write a function which behaves like reduce, but returns each intermediate value of the reduction.  Your function must accept either two or three arguments, and the return sequence must be lazy.
; http://www.4clojure.com/problem/60
; Don't use: reductions

; (= (take 5 (__ + (range))) [0 1 3 6 10])
; (= (__ conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]])
; (= (last (__ * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120)

