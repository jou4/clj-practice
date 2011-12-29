(ns clj-practice.match)

(def re1 #"\d{3}\-\d{4}")
(re-find re1 "123-4567")
(re-find re1 "123 - 4567")
(re-find re1 "123-4567 234-5678")
(re-seq re1 "123-4567 234-5678")


(def re2 (re-pattern "\\d{3}\\-\\d{4}"))
(re-find re2 "123-4567")
(re-find re2 "123 - 4567")


(def re3 #"(\d{3})\-(\d{4})")
(re-find (re-matcher re3 "123-4567"))
(re-matches re3 "123-4567")
(re-matches re3 " 123-4567 ")
