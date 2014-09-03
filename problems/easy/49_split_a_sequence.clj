; Write a function which will split a sequence into two parts.
; http://www.4clojure.com/problem/49
; Don't use: split-at

; (= (__ 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]])
; (= (__ 1 [:a :b :c :d]) [[:a] [:b :c :d]])
; (= (__ 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]])

(fn [n coll] [(take n coll) (drop n coll)])