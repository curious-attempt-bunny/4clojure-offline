; Happy numbers are positive integers that follow a particular formula: take each individual digit, square it, and then sum the squares to get a new number. Repeat with the new number and eventually, you might get to a number whose squared sum is 1. This is a happy number. An unhappy number (or sad number) is one that loops endlessly. Write a function that determines if a number is happy or not.
; http://www.4clojure.com/problem/86

; (= (__ 7) true)
; (= (__ 986543210) true)
; (= (__ 2) false)
; (= (__ 3) false)

(fn [n]
	(loop [i n explored #{}]
		(if (= i 1)
			true
			(if (contains? explored i)
				false
				(let [next (->> i .toString
											vec
											(map str)
											(map #(Integer/parseInt %))
											(map #(* % %))
											(reduce +))]
					(recur next (conj explored i)))))))