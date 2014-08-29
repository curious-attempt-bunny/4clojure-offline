; Take a set of functions and return a new function that takes a variable number of arguments and returns a sequence containing the result of applying each function left-to-right to the argument list.
; http://www.4clojure.com/problem/59
; Don't use: juxt

; (= [21 6 1] ((__ + max min) 2 3 5 1 6 4))
; (= ["HELLO" 5] ((__ #(.toUpperCase %) count) "hello"))
; (= [2 6 4] ((__ :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10}))

(fn [& fs] (fn [& args] (for [f fs] (apply f args))))