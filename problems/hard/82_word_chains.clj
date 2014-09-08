; A word chain consists of a set of words ordered so that each word differs by only one letter from the words directly before and after it.  The one letter difference can be either an insertion, a deletion, or a substitution.  Here is an example word chain:cat -> cot -> coat -> oat -> hat -> hot -> hog -> dogWrite a function which takes a sequence of words, and returns true if they can be arranged into one continous word chain, and false if they cannot.
; http://www.4clojure.com/problem/82

; (= true (__ #{"hat" "coat" "dog" "cat" "oat" "cot" "hot" "hog"}))
; (= false (__ #{"cot" "hot" "bat" "fat"}))
; (= false (__ #{"to" "top" "stop" "tops" "toss"}))
; (= true (__ #{"spout" "do" "pot" "pout" "spot" "dot"}))
; (= true (__ #{"share" "hares" "shares" "hare" "are"}))
; (= false (__ #{"share" "hares" "hare" "are"}))

(fn chainable?
	([words] (true? (some #(chainable? (disj words %) % []) words)))
	([words leading route]
		(if (empty? words)
			true
			(some
				true?
				(for [other words]
					(let [remaining  (disj words leading other)
								diff_index (fn [w1 w2]
															(loop [a (vec w1)
																		 b (vec w2)
																		 i 0]
																(if (and (empty? a) (empty? a))
																	i
																	(if (= (first a) (first b))
																		(recur (rest a) (rest b) (inc i))
																		i))))
								diff_left  (diff_index leading other)
								diff_right (diff_index (clojure.string/reverse leading) (clojure.string/reverse other))
								diff_total (+ diff_left diff_right)
								target     (dec (max (count leading) (count other)))
								valid?     (= diff_total target)
								route      (conj route other)]
						(when valid?
							(chainable? remaining other route))))))))

				
			