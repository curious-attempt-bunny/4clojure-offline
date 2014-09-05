; A <a href="http://en.wikipedia.org/wiki/Tic-tac-toe">tic-tac-toe board is represented by a two dimensional vector. X is represented by :x, O is represented by :o, and empty is represented by :e.  A player wins by placing three Xs or three Os in a horizontal, vertical, or diagonal row.  Write a function which analyzes a tic-tac-toe board and returns :x if X has won, :o if O has won, and nil if neither player has won.
; http://www.4clojure.com/problem/73

; (= nil (__ [[:e :e :e]             [:e :e :e]             [:e :e :e]]))
; (= :x (__ [[:x :e :o]            [:x :e :e]            [:x :e :o]]))
; (= :o (__ [[:e :x :e]            [:o :o :o]            [:x :e :x]]))
; (= nil (__ [[:x :e :o]             [:x :x :e]             [:o :x :o]]))
; (= :x (__ [[:x :e :e]            [:o :x :e]            [:o :e :x]]))
; (= :o (__ [[:x :e :o]            [:x :o :e]            [:o :e :x]]))
; (= nil (__ [[:x :o :x]             [:x :o :x]             [:o :x :o]]))

(fn [[a b c]]
	(let [lines 
					[a 
					 b
					 c
					 [(first a) (first b) (first c)]
					 [(second a) (second b) (second c)]
					 [(last a) (last b) (last c)]
					 [(first a) (second b) (last c)]
					 [(first c) (second b) (last a)]]]
		(first (filter
							identity
							(map
								(fn [line]
									(let [winner (first line)
										    wins   (every? #(= winner %) line)]
										(if (or (false? wins) (= :e winner)) nil winner)))
								lines)))))
