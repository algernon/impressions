(ns impressions.balabit-lll-20130219
  (:use [impressive-hiccups.element]
        [impressive-hiccups.page]
        [hiccup.element]))

(defn balabit-lll-20130219
  []

  (impress
   {:title "???"
    :font-uri "http://fonts.googleapis.com/css?family=Titillium+Web"}
   (group
    {:x 0 :y 0
     :scale 0.5}
    (slide {:id "intro"}
           [:img {:src "img/cm-eats-data.png"
                  :style "width: 95%; height: 95%; border: 1px solid #888; padding: 3px;"}])
    (slide {:x -50 :y 0 :scale 0.01}
           (fh1 {:class "largest"
                 :style "margin-left: -0.5em; font-size: 250px;"} "Cookies?!")))

   (group
    {:rotate 270
     :x 600 :y 0
     :scale 1}
    (slide {:id "clojure-intro"}
           (fh1 "A clojure, mint nyelv")))

   (group
    {:x -150 :y -800
     :rotate 180
     :scale 1}
    (slide {:id "everything-is-a-value"}
           (fh1 "Minden érték")))

   (group
    {:x -600 :y 100
     :rotate 90
     :scale 1}
    (slide {:id "nyelvek"}
           (fh1 "Debugolásnál mit nézünk?")))

   (group
    {:x 100 :y 800
     :scale 1}
    (slide {:id "data?"}
           (fh1 "Mi a program legfontosabb része?")))

   (group
    {:x 100 :y 1600}
    (slide {:id "data-1"}
           [:img {:src "img/data-2.jpg"
                  :style "width: 95%; height: 95%;"}])
    (slide {:id "data-2"
            :y 2400}
           [:img {:src "img/data-1.jpg"}])
    (group
     {:x 1100 :y 2400}
     (slide {:id "data-why?"}
            (fh1 "Miért?"))

     (group
      {:y 100}
      (slide {}
             (fh3 "Mert adat nélkül semmik vagyunk."))
      (slide {:scale 0.1
              :id "gol"
              :y -100}
             [:pre {:style "font-size: 0.75em; margin-left: -3.5em"} (interpose "\n" ["(defn neighbours [[x y]]"
"  (for [dx [-1 0 1] dy (if (zero? dx) [-1 1] [-1 0 1])]"
"    [(+ dx x) (+ dy y)]))"
""
"(defn step [cells]"
"  (set (for [[loc n] (frequencies (mapcat neighbours cells))"
"             :when (or (= n 3) (and (= n 2) (cells loc)))]"
"         loc)))"])])

      (slide {:y 300}
             (fh3 "Adat nélkül nincs tesztelés, nincs élet."))))

    (group
     {:y 3600
      :x 1100
      :rotate 180}
     (slide {:id "tanulsag"}
            (fh1 {:class "xx-large"} "Tanulság?"))

     (group
      {}
      (slide {:y 160}
             (fh3 "A program transzformációk sorozata"))
      (slide {:y 220}
             (fh3 "Az adat egyszerűen követhető"))
      (slide {:y 280}
             (fh3 "Az adat szent és sérthetetlen"))
      (slide {:y 340
              :scale 0.5}
             (fh3 {:style "color: red;"}
                  "Miért piszkáljuk akkor mindig?!")))))
   

   (slide
    {:x 0 :y 0 :scale 3 :id "overview"}
    "")))
