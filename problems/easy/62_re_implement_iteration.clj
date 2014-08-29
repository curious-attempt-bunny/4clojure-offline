; Given a side-effect free function f and an initial value x write a function which returns an infinite lazy sequence of x, (f x), (f (f x)), (f (f (f x))), etc.
; http://www.4clojure.com/problem/62
; Don't use: iterate

; (= (take 5 (__ #(* 2 %) 1)) [1 2 4 8 16])
; (= (take 100 (__ inc 0)) (take 100 (range)))
; (= (take 9 (__ #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3])))

