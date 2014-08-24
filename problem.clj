(= (__ 2) [2 3])
(= (__ 5) [2 3 5 7 11])
(= (last (__ 100)) 541)

(fn [i] (take i (filter (fn [n] (not-any? #(= 0 (mod n %)) (drop 2 (range n)))) (drop 2 (range)))))