(ns clj-practice.io)

(require '[clojure.java.io :as io])


(def in-file "project.clj")
(def out-file "out.txt")


(println (slurp in-file))
(spit out-file "out1\n" :append true)


(with-open [r (io/reader in-file)]
  (doseq [line (line-seq r)]
    (println line)))

(with-open [w (io/writer out-file :append true)]
  (.write w "out2\n"))


(.delete (io/file out-file))
