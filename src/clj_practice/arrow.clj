(ns clj-practice.arrow)

(->> [1 2 3]
  (map #(* 2 %))
  (filter #(< 3 %)))

