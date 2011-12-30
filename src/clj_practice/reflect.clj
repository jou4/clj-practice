(ns clj-practice.reflect)

(class [])
(class? [])

(def c1 (class []))

(class c1)
(class? c1)

(doseq [m (.getMethods java.lang.Class)] (println m))
(doseq [m (.getMethods java.lang.reflect.Method)] (println m))
(doseq [m (.getMethods c1)] (println m))
