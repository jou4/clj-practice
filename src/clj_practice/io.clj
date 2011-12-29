(ns clj-practice.io)

(require '[clojure.contrib.duck-streams :as ds])

(ds/pwd)
(ds/read-lines "project.clj")


(ds/to-byte-array (ds/reader "project.clj"))
(seq (ds/to-byte-array "abcde"))


(let [lines (ds/read-lines "project.clj")]
  (loop [lines lines]
    (when-let [line (first lines)]
      (println (str line))
      (recur (rest lines)))))
