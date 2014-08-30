; Write a function which takes a string and returns a new string containing only the capital letters.
; http://www.4clojure.com/problem/29

; (= (__ "HeLlO, WoRlD!") "HLOWRD")
; (empty? (__ "nothing"))
; (= (__ "$#A(*&987Zf") "AZ")

#(clojure.string/replace % #"[^A-Z]", "")