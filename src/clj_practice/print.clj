(ns clj-practice.pprint)

(def a [[:id 1 :name "Taro"]
        [:id 2 :name "Jiro"]
        [:id 3 :name "Saburo"]])

(def b {:a 100 :b 200})


(print 123)
(print "abc")
(print 123 "abc")

(println 123)
(println "abc")
(println 123 "abc")

(print-str 123)
(println-str 123 "abc")

(println a)
(println (first a))
(println b)
(println (:a b))


(require '[clojure.pprint :as pp])

(printf "%d - %s\n" 123 "abc")
(printf "%d - %s\n" 123 a)

(pp/pprint a)
(pp/pprint a *out*)
