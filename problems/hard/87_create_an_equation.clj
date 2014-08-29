; Write a function which takes three or more integers.  Using these integers, your function should generate clojure code representing an equation.  The following rules for the equation must be satisfied:    1. All integers must be used once and only once.    2. The order of the integers must be maintained when reading the equation left-to-right.    3. The only functions you may use are +, *, or =.    4. The equation must use the minimum number of parentheses.    5. If no satisfying equation exists, return nil.
; http://www.4clojure.com/problem/87

; (= (__ 3 4 7) '(= (+ 3 4) 7))
; (= (__ 3 4 12) '(= (* 3 4) 12))
; (= (__ 3 4 14) nil)
; (= (__ 3 4 5 35) '(= (* (+ 3 4) 5) 35))
; (= (__ 3 4 5 60) '(= (+ (* 3 4) 5) 60))
; (= (__ 3 4 5 23) '(= (+ 3 (* 4 5)) 23))
; (= (__ 3 4 5 27) '(= (* 3 (+ 4 5)) 27))
; (= (__ 3 4 5 6) nil)
; (= (__ 1 2 10 100 2001) '(= (+ 1 (* 2 10 100)) 2001)
; (= (__ 1 2 10 100 1300) '(= (* (+ 1 2 10) 100) 1300)

