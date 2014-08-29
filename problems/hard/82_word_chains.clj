; A word chain consists of a set of words ordered so that each word differs by only one letter from the words directly before and after it.  The one letter difference can be either an insertion, a deletion, or a substitution.  Here is an example word chain:cat -> cot -> coat -> oat -> hat -> hot -> hog -> dogWrite a function which takes a sequence of words, and returns true if they can be arranged into one continous word chain, and false if they cannot.
; http://www.4clojure.com/problem/82

; (= true (__ #{"hat" "coat" "dog" "cat" "oat" "cot" "hot" "hog"}))
; (= false (__ #{"cot" "hot" "bat" "fat"}))
; (= false (__ #{"to" "top" "stop" "tops" "toss"}))
; (= true (__ #{"spout" "do" "pot" "pout" "spot" "dot"}))
; (= true (__ #{"share" "hares" "shares" "hare" "are"}))
; (= false (__ #{"share" "hares" "hare" "are"}))

