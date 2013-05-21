(ns impressions.all
  (:use [impressions.threads-of-doom]
        [impressions.balabit-lll-20130219]
        [impressions.index]
        [impressions.gyaszbeszed-az-objektumok-felett]))

(defmacro make-impression
  [source]

  (let [fn (str "public/" source "/index.html")
        imp (ns-resolve 'impressions.all source)]
    (spit fn (imp))))

(defn make-all-impressions
  []

  (make-impression threads-of-doom)
  (make-impression balabit-lll-20130219)
  (make-impression gyaszbeszed-az-objektumok-felett)

  (make-impression index))

(defn -main
  [& _]

  (dorun (make-all-impressions)))
