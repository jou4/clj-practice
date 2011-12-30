(ns clj-practice.loop)

; (doc doseq)
(doseq [n (range 10)]
  (println n))

; (doc range)
(doseq [a (range 1 4) b (range 4 7)]
  (println (str a " - " b)))

; (doc loop)
(loop [nums [\a \b \c]]
  (when-let [n (first nums)]
    (println n)
    (recur (rest nums))))

; (doc for)
(for [x (range 10)
      :when (= 0 (mod x 2))]
  [x])

(for [x (range 1 11 2)
      y (range 11 21 2)]
  [x y])
