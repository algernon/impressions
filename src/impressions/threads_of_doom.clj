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
            (fh1 "Shared data"))

     (group {}
      (slide {:x -400 :y 860}
             (fh1 "Locking"))

      (slide {:x -300 :y 960}
             (fh2 "Races"))

      (slide {:x -300 :y 1060}
             (fh2 "Deadlocks"))

      (slide {:x -300 :y 1160}
             (fh2 "Granularity"))

      (slide {:x -300 :y 1260}
             (fh2 "Two-step dance")))

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
     (group {}
            (slide {:x -600 :y 360}
                   (fh1 "Avoiding shared state"))

            (slide {:x -300 :y 460
                    :scale 1.5}
                   (fh2 "Re-entrancy"))

            (slide {:x -300 :y 560
                    :scale 1.5}
                   (fh2 "Thread-local storage")))

     ;; --
     (group {}
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
                   (fh2 "Immutability")))

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

    (slide {:id "primitives"}
           (fh1 "Shifting computation through time and space"))

    (group {}
           (slide {:scale 0.75
                   :y -60}
                  (fh2 "Primitive concurrency types"))
           (group {:scale 0.75
                   :x 150
                   :y 110}
                  (slide {}
                         [:p "Evaluated once, caches results"])
                  (slide {:y 60}
                         [:p "Blocks on deref"]))

           (group
            {:scale 0.01}

            (group {}
                   (slide {:id "delays"}
                          (fh1 {:class "largest"} "Delays"))
                   (group {:scale 0.75
                           :x -100
                           :y 160}

                          (slide {}
                                 [:p "Computed on demand"])
                          (slide {:y 80}
                                 [:p "Opt-in cost"])))

            (group {:x 1500
                    :y 240
                    :scale 0.75}
                   (slide {:id "futures"}
                          (fh1 {:class "largest"} "Futures"))
                   (group {:scale 0.75
                           :x -100
                           :y 160}

                          (slide {}
                                 [:p "Run immediately in the background"])
                          (slide {:y 80}
                                 [:p "Optional timeout on deref"])
                          (slide {:y 160}
                                 [:p "Shares thread pool with agents"])
                          (slide {:y 240}
                                 [:p "Simple concurrency"])))

            (group {:x 2500
                    :y 480
                    :scale 0.5625}
                   (slide {:id "promises"}
                          (fh1 {:class "largest"} "Promises"))
                   (group {:scale 0.75
                           :x -100
                           :y 160}

                          (slide {}
                                 [:p "Barren container at init"])
                          (slide {:y 80}
                                 [:p "Value needs to be delivered separately"])
                          (slide {:y 200}
                                 [:p "Can be used to make callback-based APIs synchronous"]))))

           (group {:x 600
                   :y -160
                   :scale 0.5
                   :rotate 60}
                  (slide {:id "primitive-demo"}
                         (fh1 {:class "largest"} "DEMO!")))))

   (group {:x 2200 :y 4000
           :rotate 80}
          (slide {:id "reference-types"
                  :y 800}
                 (fh1 "Reference types"))

          (group {:scale 0.75
                  :y 900
                  :x -100}
                 (slide {}
                        [:p "Boxes"])
                 (slide {:y 80}
                        [:p "deref returns a snapshot"])
                 (slide {:y 160}
                        [:p "deref never blocks"])
                 (slide {:y 240}
                        [:p "watchers & validators"])
                 (slide {:y 320}
                        [:p "coordination & synchronisation"])

                 (slide {:x 600
                         :y 120}
                        [:table {:border 1}
                         [:tr {:style "background: #bbb;"}
                          [:td ""]
                          [:td "coord"]
                          [:td "uncoord"]]
                         [:tr
                          [:td {:style "background: #bbb;"} "sync"]
                          [:td "Refs"]
                          [:td "Atoms"]]
                         [:tr
                          [:td {:style "background: #bbb;"} "async"]
                          [:td {:style "background: black;"} ""]
                          [:td "Agents"]]])

                 (group {:scale 0.01}

                        (group {}
                               (slide {:id "atoms"}
                                      (fh1 {:class "largest"} "atoms"))
                               (group {:scale 0.75
                                       :x -100
                                       :y 100}
                                      (slide {}
                                             [:p "Synchronous"])
                                      (slide {:y 60}
                                             [:p "Uncoordinated"])
                                      (slide {:y 120}
                                             [:p "compare-and-set"])
                                      (slide {:y 180}
                                             [:p "blocks on set"])
                                      (slide {:y 240}
                                             [:p "can't coordinate atoms"])))

                        (group {:x 1200
                                :y 240
                                :scale 0.75}
                               (slide {:id "refs"}
                                      (fh1 {:class "largest"} "refs"))
                               (group {:scale 0.75
                                       :x -100
                                       :y 100}
                                      (slide {}
                                             [:p "Synchronous"])
                                      (slide {:y 60}
                                             [:p "Coordinated"])
                                      (slide {:x 500}
                                             [:p "No inconsistency"])
                                      (slide {:x 500
                                              :y 60}
                                             [:p "No races with involved refs"])
                                      (slide {:x 500
                                              :y 120}
                                             [:p "No manual locks"])
                                      (slide {:x 500
                                              :y 180}
                                             [:p "No deadlocks"])
                                      (slide {:y 180}
                                             [:p "In-transaction values"])))
                        (group {:x 2400
                                :y 420
                                :scale 0.5625}
                               (slide {:id "agents"}
                                      (fh1 {:class "largest"} "Agents")))
                        )))
   
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
