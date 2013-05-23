(ns impressions.index
  (:use [impressive-hiccups.element]
        [impressive-hiccups.page]
        [hiccup.element]))

(defn index
  []

  (impress
   {:title "algernon's impressions"}

   (group
    {:x 0 :y 0}
    (slide
     {:id "index"}
     (fh1 "algernon's impressions"))

    (group
     {:scale 0.75
      :y 120}

     (slide
      {:id "clojure-intro"
       :x -160}
      (fh2 (link-to "../balabit-lll-20130219/" "Clojure intro")))

     (slide
      {:id "threads-of-doom"
       :x 500}
      (fh2 (link-to "../threads-of-doom/" "Threads of Doom")))

     (slide
      {:id "gyaszbeszed-az-objektumok-felett"
       :x 0
       :y 160}
      (fh2 (link-to "../gyaszbeszed-az-objektumok-felett/"
                    "Gyászbeszéd az objektumok felett")))))))
