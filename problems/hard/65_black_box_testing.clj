; Clojure has many collection types, which act in subtly different ways. The core functions typically convert them into a uniform "sequence" type and work with them that way, but it can be important to understand the behavioral and performance differences so that you know which kind is appropriate for your application.<br /><br />Write a function which takes a collection and returns one of :map, :set, :list, or :vector - describing the type of collection it was given.<br />You won't be allowed to inspect their class or use the built-in predicates like list? - the point is to poke at them and understand their behavior.
; http://www.4clojure.com/problem/65
; Don't use: class, nor type, nor Class, nor vector?, nor sequential?, nor list?, nor seq?, nor map?, nor set?, nor instance?, nor getClass

; (= :map (__ {:a 1, :b 2}))
; (= :list (__ (range (rand-int 20))))
; (= :vector (__ [1 2 3 4 5 6]))
; (= :set (__ #{10 (rand-int 5)}))
; (= [:map :set :vector :list] (map __ [{} #{} [] ()]))

