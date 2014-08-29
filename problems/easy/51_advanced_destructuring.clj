; Here is an example of some more sophisticated destructuring.
; http://www.4clojure.com/problem/51

; (= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] __] [a b c d]))

