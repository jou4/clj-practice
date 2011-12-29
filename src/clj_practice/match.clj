(ns clj-practice.match)

(def re1 #"\d{3}\-\d{4}")

(re-find re1 "123-4567")
(re-find re1 "123 - 4567")

(re-find re1 "123-4567 234-5678")
(re-seq re1 "123-4567 234-5678")

(import '[java.util.regex Pattern])


(def re2 (Pattern/compile "\\d{3}\\-\\d{4}" Pattern/CASE_INSENSITIVE))

(re-find re2 "123-4567")
(re-find re2 "123 - 4567")


(def re3 #"\d{3}")
; (re-groups (re-matcher re3 "123-4567"))

