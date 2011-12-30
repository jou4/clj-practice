(ns clj-practice.coll)

(def s1 [1 2 3])
(def s2 '(1 2 3))
(def s3 #{\a \b \c})
(def s4 {:id 1 :name "Taro"})
(def s5 [:a 1 :b 2 :c 3])
(def s6 (hash-map :id 2 :name "Jiro"))
(def s7 (sorted-map :c 1 :b 2 :a 3))
(def s8 (hash-set \c \b \a))
(def s9 (sorted-set \c \b \a))

(def ss [s1 s2 s3 s4 s5 s6 s7 s8 s9])

(println ss)
(map #(class %) ss)
(map #(seq %) ss)
(map #(vec %) ss)
(map #(vector? %) ss)
(map #(list? %) ss)
(map #(seq? %) ss)
(map #(coll? %) ss)
(map #(map? %) ss)
(map #(set? %) ss)


(s3 \a)
(s8 \a)
(s9 \a)

(:name s4)
(s4 :name)
(keys s4)
(vals s4)
