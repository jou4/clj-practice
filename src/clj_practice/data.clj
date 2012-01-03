(ns clj-practice.data)

; var
(def ^:dynamic v 1)
(println v)
(do
  (binding [v 100]
    (println v))
  (println v))

; ref
(def person (ref {:id 1 :name "Taro"}))
(println @person)
(println (:id @person))
(println (@person :name))
(dosync
  (ref-set person {:id 2 :name "Jiro"}))
(dosync
  (alter person assoc :sex "male" :age 23))

(def logs (ref ""))
(do
  (.start (Thread.
            #(dosync
               (println "-- Begin A:" @logs)
               (alter logs str "A")
               (println "-- Updated A:" @logs)
               (Thread/sleep 3000)
               (println "-- End A:" @logs))))
  (.start (Thread.
            #(dosync
               (println "** Begin B:" @logs)
               (Thread/sleep 1000)
               (alter logs str "B")
               (println "** Updated B:" @logs)
               (println "** End B:" @logs)))))

(def logs (ref ""))
(do
  (.start (Thread.
            #(dosync
               (println "-- Begin A:" @logs)
               (alter logs str "A")
               (println "-- Updated A:" @logs)
               (Thread/sleep 3000)
               (println "-- End A:" @logs))))
  (.start (Thread.
            #(dosync
               (println "** Begin B:" @logs)
               (Thread/sleep 1000)
               (commute logs str "B")
               (println "** Updated B:" @logs)
               (println "** End B:" @logs)))))

(def logs (ref ""))
(do
  (.start (Thread.
            #(dosync
               (println "-- Begin A:" @logs)
               (commute logs str "A")
               (println "-- Updated A:" @logs)
               (Thread/sleep 3000)
               (println "-- End A:" @logs))))
  (.start (Thread.
            #(dosync
               (println "** Begin B:" @logs)
               (Thread/sleep 1000)
               (alter logs str "B")
               (println "** Updated B:" @logs)
               (println "** End B:" @logs)))))

(def logs (ref ""))
(do
  (.start (Thread.
            #(dosync
               (println "-- Begin A:" @logs)
               (alter logs str "A")
               (println "-- Updated A:" @logs)
               (Thread/sleep 3000)
               (println "-- End A:" @logs))))
  (.start (Thread.
            #(dosync
               (ensure logs)
               (println "** Begin B:" @logs)
               (Thread/sleep 1000)
               (alter logs str "B")
               (println "** Updated B:" @logs)
               (println "** End B:" @logs)))))

; atom
(def song (atom {:title "Let it be" :artist "Beatles"}))
(println @song)
(reset! song {:title "Help" :artist "Beatles"})
(swap! song assoc :title "Hey, Jude" :year 1967)

; agent
(def counter (agent 0))
(send counter inc)
(send-off counter inc)
(println @counter)

(def counter (agent 0 :validator number?))
(send counter #("hoge"))
(send-off counter #("hoge"))
(agent-error counter)
(agent-errors counter)
(clear-agent-errors counter)
(println @counter)
