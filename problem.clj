(= (__ "4,5,6,7,8,9") "4,9")
(= (__ "15,16,25,36,37") "16,25,36")

(fn [str] (let [ns (map #(Integer/parseInt %) (clojure.string/split str #","))
								sq (filter #(zero? (rem % (Math/sqrt %))) ns)] 
						(clojure.string/join "," sq)))

	