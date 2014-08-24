(= (__  "Have a nice day.") ["a" "day" "Have" "nice"])
(= (__  "Clojure is a fun language!") ["a" "Clojure" "fun" "is" "language"])
(= (__  "Fools fall for foolish follies.") ["fall" "follies" "foolish" "Fools" "for"])

(fn [str] (sort-by #(.toLowerCase %)
	          (clojure.string/split (clojure.string/replace str #"[^A-Za-z\s]" "") #" ")))