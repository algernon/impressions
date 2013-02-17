(ns impressions.threads-of-doom
  (:use [impressive-hiccups.element]
        [impressive-hiccups.page]
        [hiccup.element]))

(defn threads-of-doom
  []

  (impress {:title "Threads of Doom"}
   (group
    {:x 0 :y 0}
    (slide {:id "threads-of-doom"}
           (fh1 {:class "xx-large"} "Threads of Doom"))

    (slide
     {:x -210 :y 150 :scale 0.1}
     [:p {:class "large"} [:strong "You were doing it wrong"]]))

   ;; ==
   (group
    {:x 800 :y 400
     :rotate 30}

    (slide {:id "problems-with-threads"}
           (fh2 {:class "xx-large"} "Thread problems"))

    (group
     {:scale 0.5}
     (slide {:x -400 :y 760}
            (fh1 "Synchronizing data"))

     (slide {:x -400 :y 860}
            (fh1 "Locking"))

     (slide {:x -300 :y 960}
            (fh2 "Races"))

     (slide {:x -300 :y 1060}
            (fh2 "Deadlocks"))

     (slide {:x -300 :y 1160}
            (fh2 "Granularity"))

     (slide {:x -300 :y 1260}
            (fh2 "Two-step dance"))

     (slide {:x -400 :y 1360}
            (fh1 "Priority inversion"))))

   ;; ==
   (group
    {:x 1600 :y 1000
     :rotate 60}

    (slide {:id "solutions?"}
           (fh2 {:class "xx-large"} "Solutions"))

    (group
     {:scale 0.5}

     ;; --
     (slide {:x -600 :y 360}
            (fh1 "Avoiding shared state"))

     (slide {:x -300 :y 460
             :scale 1.5}
            (fh2 "Re-entrancy"))

     (slide {:x -300 :y 560
             :scale 1.5}
            (fh2 "Thread-local storage"))

     ;; --
     (slide {:x 500 :y 360}
            (fh1 "Synchronisation"))

     (slide {:x 800 :y 460
             :scale 1.5}
            (fh2 "Mutexes"))

     (slide {:x 800 :y 560
             :scale 1.5}
            (fh2 "Atomic ops"))

     (slide {:x 800 :y 660
             :scale 1.5}
            (fh2 "Immutability"))

     (slide {:x -100 :y 1200}
            (fh1 {:class "xx-large"} "Something different?"))))

   ;; ==
   (group
    {:x 1900 :y 2200
     :rotate 120}

    (slide {:id "clojure"}
           [:img {:src "img/Clojure-glyph.svg"}]))

   ;; ==
   (group
    {:x 2200 :y 3400
     :rotate 80}

    (slide {:id "atoms"}
           (fh1 {:class "largest"} "atoms"))

    (group
     {:scale 0.75}

     ;; --
     (slide {:x -100 :y 160}
            (fh2 "An atomic operation"))

     (slide {:x 0 :y 360}
            [:ul
             [:li "One data item to manipulate"]
             [:li "Like a counter!"]
             [:li "One single state at a time"]
             ])))

   ;; ==
   (group
    {:x 500 :y 3000
     :rotate 260}

    (slide {:id "refs"}
           (fh1 {:class "largest"} "refs"))

    (group
     {:scale 0.75}

     ;; --
     (slide {:x -100 :y 200}
            (fh2 "Same identity over a period of time"))

     (slide {:x 0 :y 460}
            [:ul
             [:li "Coordinate several data structures"]
             [:li "Like an SQL transaction"]
             [:li "Other threads see the old state"]])))

   ;; ==
   (group
    {:x 300 :y 1800
     :rotate 250}

    (slide {:id "futures"}
           (fh1 {:class "largest"} "futures"))

    (group
     {:scale 0.75}

     (slide {:x -100 :y 160}
            (fh2 "async request/response"))

     (slide {:x 0 :y 360}
            [:ul
             [:li "..."]])))

   ;; ==
   (group
    {:x -700 :y 1200
     :rotate 190}

    (slide {:id "agents"}
           (fh1 {:class "largest"} "agents"))

    (group
     {:scale 0.75}

     (slide {:x -100 :y 160}
            (fh2 "..."))

     (slide {:x 0 :y 360}
            [:ul
             [:li "..."]])))

   ;; ==
   (group
    {:x -1900 :y 1200
     :rotate 180}

    (slide {:id "promises"}
           (fh1 {:class "largest"} "promises"))

    (group
     {:scale 0.75}

     (slide {:x -100 :y 200}
            (fh2 "..."))

     (slide {:x 0 :y 360}
            [:ul
             [:li "..."]])))

   ;; ==
   (group
    {:x -2000 :y 100
     :rotate 90}

    (slide {:id "for-the-doomed"}
           (fh1 {:class "largest"} "For the doomed"))

    (group
     {:scale 0.1}

     (slide {:x 0 :y 0}
            (fh2 "Executor"))))

   ;; ==
   (group
    {:x -3000 :y 100
     :rotate 90}

    (slide {:id "the-end"}
           (fh1 {:class "xx-large"} "The End"))

    (group
     {:scale 0.5}

     (slide {:x 0 :y 300}
            [:p {:class "left"} "© 2013 Gergely Nagy, "
             (link-to "https://twitter.com/algernoone" "@algernoone")
               " / "
             (link-to "http://asylum.madhouse-project.org/" "blog")]
            [:a {:class "right"
                 :href "http://creativecommons.org/licenses/by-sa/3.0/deed.en_US"}
             [:img {:class "right"
                    :src "http://i.creativecommons.org/l/by-sa/3.0/88x31.png"}]])))

   ;; ==
   (slide
    {:x 200 :y 1800 :scale 6 :id "overview"}
    "")))
