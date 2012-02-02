(ns clj-practice.protocol)

(defrecord Point [x y])

(defprotocol Showable
  (show [this])
  (p [this]))

(extend-protocol Showable
  java.lang.String
  (show [this] (str "String " this))
  (p [this] (println (show this)))

  Point
  (show [this] (str "Point {x:" (:x this) ", y:" (:y this) "}"))
  (p [this] (println (show this)))
  )

(deftype Rect [x y w h]
  Showable
  (show [this] (str "Rect {x:" x ", y:" y ", w:" w ", h:" h "}"))
  (p [this] (println (show this))))

(deftype Rect2 [x y w h])
(extend-type Rect2
  Showable
  (show [this]
    (str "Rect {x:" (.x this)
         ", y:" (.y this)
         ", w:" (.w this)
         ", h:" (.h this) "}"))
  (p [this] (println (show this))))

(extend-type java.lang.Long
  Showable
  (show [this] (str "Long " this))
  (p [this] (println (show this))))

(show "abc")
(show (Point. 10 20))
(show (Rect. 0 0 100 200))
(show (Rect2. 0 0 200 300))
(show 111)
