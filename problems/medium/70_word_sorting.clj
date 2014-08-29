; Write a function which splits a sentence up into a sorted list of words.  Capitalization should not affect sort order and punctuation should be ignored.
; http://www.4clojure.com/problem/70

; (= (__  "Have a nice day.")    ["a" "day" "Have" "nice"])
; (= (__  "Clojure is a fun language!")    ["a" "Clojure" "fun" "is" "language"])
; (= (__  "Fools fall for foolish follies.")    ["fall" "follies" "foolish" "Fools" "for"])

(fn [str] (sort-by #(.toLowerCase %)
	          (clojure.string/split (clojure.string/replace str #"[^A-Za-z\s]" "") #" ")))