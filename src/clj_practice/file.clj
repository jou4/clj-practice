(ns clj-practice.file)

(require '[clojure.java.io :as io])

; (doseq [m (.getMethods java.io.File)] (println m))

(doseq [f (file-seq (io/file "lib"))] (println (.getName f)))

(map #(.getName %)
     (filter #(.isDirectory %) (.listFiles (io/file "lib"))))

(map #(.getName %)
     (filter #(.isFile %) (.listFiles (io/file "lib"))))
