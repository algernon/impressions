(ns impressions.all
  (:use [impressions.threads-of-doom]))

(defmacro make-impression
  [source]

  (let [fn (str "public/" source "/index.html")
        imp (ns-resolve 'impressions.all source)]
    (spit fn (imp))))

(defn make-all-impressions
  []

  (make-impression threads-of-doom))

(defn -main
  [& _]

  (dorun (make-all-impressions)))
