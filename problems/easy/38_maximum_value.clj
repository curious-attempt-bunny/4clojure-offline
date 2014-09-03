; Write a function which takes a variable number of parameters and returns the maximum value.
; http://www.4clojure.com/problem/38
; Don't use: max, nor max-key

; (= (__ 1 8 3 4) 8)
; (= (__ 30 20) 30)
; (= (__ 45 67 11) 67)

#(reduce (fn [acc elem] (if (> elem acc) elem acc)) %&)