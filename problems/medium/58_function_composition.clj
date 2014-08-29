; Write a function which allows you to create function compositions.  The parameter list should take a variable number of functions, and create a function applies them from right-to-left.
; http://www.4clojure.com/problem/58
; Don't use: comp

; (= [3 2 1] ((__ rest reverse) [1 2 3 4]))
; (= 5 ((__ (partial + 3) second) [1 2 3 4]))
; (= true ((__ zero? #(mod % 8) +) 3 5 7 9))
; (= "HELLO" ((__ #(.toUpperCase %) #(apply str %) take) 5 "hello world"))

(fn [& args] (reduce #(fn [& _args] (%2 (apply %1 _args))) (reverse args)))
