(ns clj-practice.array)

(require '[clojure.pprint :as pp])

(let [ia (int-array [1 2 3 4 5])]
  (println (alength ia))
  (println (aget ia 0))
  (println (aset ia 1 10))
  (pp/pprint ia))

(let [ca (char-array [\a \b \c \d \e])]
  (loop [ary ca]
    (when-let [c (first ary)]
      (println c)
      (recur (rest ary)))))
