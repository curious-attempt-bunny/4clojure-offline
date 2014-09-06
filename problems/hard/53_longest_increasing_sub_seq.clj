; Given a vector of integers, find the longest consecutive sub-sequence of increasing numbers. If two sub-sequences have the same length, use the one that occurs first. An increasing sub-sequence must have a length of 2 or greater to qualify.
; http://www.4clojure.com/problem/53

; (= (__ [1 0 1 2 3 0 4 5]) [0 1 2 3])
; (= (__ [5 6 1 3 2 7]) [5 6])
; (= (__ [2 3 3 4 5]) [3 4 5])
; (= (__ [7 6 5 4]) [])

(fn [coll]
	(loop [best [] current [] remaining coll]
		(if (empty? remaining)
			(if (> (count best) 1) best [])
			(let [next       (first remaining)
						ascending? (or (empty? current) (> next (last current)))
						ncurrent   (if ascending? (conj current next) [next])
						nbest      (if (> (count ncurrent) (count best)) ncurrent best)]
				(recur nbest ncurrent (rest remaining))))))