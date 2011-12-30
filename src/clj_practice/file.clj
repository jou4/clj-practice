(ns clj-practice.file)

(require '[clojure.java.io :as io])

(doseq [f (file-seq (io/file "lib"))] (println (.getName f)))
