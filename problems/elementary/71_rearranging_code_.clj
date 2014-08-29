; The -> macro threads an expression x through a variable number of forms. First, x is inserted as the second item in the first form, making a list of it if it is not a list already.  Then the first form is inserted as the second item in the second form, making a list of that form if necessary.  This process continues for all the forms.  Using -> can sometimes make your code more readable.
; http://www.4clojure.com/problem/71

; (= (__ (sort (rest (reverse [2 5 4 1 3 6]))))    (-> [2 5 4 1 3 6] reverse rest sort __)    5)

