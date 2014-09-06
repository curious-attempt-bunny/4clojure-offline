; Write a function which calculates the sum of the minimal path through a triangle.  The triangle is represented as a vector of vectors.  The path should start at the top of the triangle and move to an adjacent number on the next row until the bottom of the triangle is reached.
; http://www.4clojure.com/problem/79

; (= (__ [   [1]           [2 4]          [5 1 4]         [2 3 4 5]])    (+ 1 2 1 3)    7)
; (= (__ [     [3]             [2 4]            [1 9 3]           [9 9 2 4]          [4 6 6 7 8]         [5 7 3 5 1 4]])    (+ 3 4 3 2 7 1)    20)

(fn solve
	([triangle] (solve triangle 0 0))
	([triangle acc index]
		(if (empty? triangle)
			acc
			(let [layer   (first triangle)
						beneath (rest triangle)
						val     (nth layer index)
						base    (+ acc val)
						left    index
						right   (inc index)]
				(min
					(solve beneath base left)
					(solve beneath base right))))))