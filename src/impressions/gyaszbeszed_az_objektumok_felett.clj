(ns impressions.gyaszbeszed-az-objektumok-felett
  (:use [impressive-hiccups.element]
        [impressive-hiccups.page]
        [hiccup.element]))


(defn gyaszbeszed-az-objektumok-felett
  []

  (impress
   {:title "Gyászbeszéd az objektumok felett"
    :font-uri "http://fonts.googleapis.com/css?family=Titillium+Web"}

   (group
    {:x 0 :y 0}

    (slide {:id "title"}
           (fh1 "Gyászbeszéd")
           (fh2 "az objektumok felett")
           [:br]
           (link-to "https://twitter.com/algernoone"
                    "@algernoone")
           [:span {:style "float:right;"}
            "BalaBit"]))

   (group
    {:x 1200 :y -300}
    (slide {:id "kezdetek"}
           (fh1 {:class "xx-large"} "Kezdetek"))
    (group
     {:y 150}
     (slide {:id "oop"}
            "1981 - Smalltalk es az OOP")
     (slide {:id "liberate"
             :y 100}
            "1977 - John Backus: Can Programming be liberated "
            "from the von Neumann Style?")
     (slide {:id "funcprog"
             :y 220}
            "1950-197x - Funkcionális programozás (Lisp, ML, FP)")))

   (group
    {:x 2400 :y -300
     :rotate 180}
    (slide {:id "Modell"}
           (fh1 {:class "xx-large"} "Modell?"))

    (group {:y 150}
           (slide "Az OOP tükrözi az emberi gondolkodást")
           (slide
            {:y 100}
            "Az OOP szebbé, kezelhetőbbé teszi a kódot"))

    (group {:scale 0.01}
           (slide
            {:id "bad-example-1"}
            [:pre {:style "font-size: 50%"}
             "((BattleNotificationSender)
 BattleResourceMediator.getMediatorInstance().getResource(
   BattleParticipant.PROXY_PARTICIPANT,
   BattleResource.BATTLE_NOTIFICATION_SENDER)).sendNotification(
     ((BattleNotificationBuilder)
       (BattleResourceMediator.getMediatorInstance().getResource(
       BattleOrganizer.getBattleParticipant(Battle.Participant.GOOD_GUYS),
       BattleResource.BATTLE_NOTIFICATION_BUILDER))).buildNotification(
         BattleOrganizer.getBattleState(BattleResult.BATTLE_LOST),
         BattleManager.getChainOfCommand().getCommandChainNotifier()));"])))

   (group
    {:x 2400 :y 1700
     :rotate 180}
    (slide {:id "tenyleg"}
           (fh1 {:class "xx-large"} "Tényleg?!"))
    (slide {:y 1000}
           "Az OOP világában az Igék felelősek minden munkáért, "
           "de lenézi őket mindenki, ezért számukra nem "
           "engedélyezett, hogy valaha is szabadon járjanak, "
           "önmagukban. Ha egy Ige a nyilvánosság elé lép, "
           "akkor azt csak egy Főnév társaságában teheti meg."))

   (group
    {:x 0 :y 1700}
    (slide {:id "kiforditott-peldak"}
           [:pre "Airplane.fly()"])
    (slide {:y 100} [:pre "Door.open()"])
    (slide {:y 200} [:pre "file.write()"]))

   (group
    {:x 5000 :y 1700}
    (slide
     {:id "szemet-ember"}
     (fh1 "Vigyük ki a szemetet!"))
    (group
     {:y 120
      :scale 0.6}
     (slide {}
            [:b "Kiveszem"] " a szemetest a mosogató alól")
     (slide {:y 60}
            [:b "Kiviszem"] " a szemetesládáig")
     (slide {:y 120}
            [:b "Beleöntöm"] " abba")
     (slide {:y 180}
            [:b "Visszamegyek"] " a házba")
     (slide {:y 240}
            [:b "Megmosom"] " a kezem")
     (slide {:y 300}
            [:b "Leülök"] " a kanapéra")
     (slide {:y 360}
            [:b "Folytatom"] " amit ezelőtt csináltam"))

    (group
     {:x 1000 :y 120
      :scale 0.6}
     (slide {:id "szemet-oop-1"}
            [:pre
             {:style "font-size:65%"}
             "szemetes = mosogato.alattaLevoDolgok().keres('Szemetes');"])
     (slide {:y 40}
            [:pre
             {:style "font-size:65%"}
             "szemetes.megfog();"])
     (slide {:y 80}
            [:pre
             {:style "font-size:65%"}
             "szemetes.kivisz(Szemeteslada.pozicio());"])
     (slide {:y 120}
            [:pre
             {:style "font-size:65%"}
             "szemetes.kiont(Szemeteslada.teto.felnyit());"])
     (slide {:y 160}
            [:pre
             {:style "font-size:65%"}
             "en.megy(Haz);"])
     (slide {:y 200}
            [:pre
             {:style "font-size:65%"}
             "en.megmos(en.kez);"])
     (slide {:y 240}
            [:pre
             {:style "font-size:65%"}
             "en.leul(Kanape);"])
     (slide {:y 280}
            [:pre
             {:style "font-size:65%"}
             "en.folyat(en.AkarmitIsCsinaltam);"]))

    (group
     {:x 2000 :y 120
      :scale 0.6}
     (slide {:id "szemet-ember-2"}
            [:pre
             {:style "font-size:65%"} "szemetes = en.megkeres(szemetes, mosogato_alatt)"])
     (slide {:y 40}
            [:pre
             {:style "font-size:65%"}
             "en.megfog(szemetes)"])
     (slide {:y 80}
            [:pre
             {:style "font-size:65%"}
             "en.kivisz(szemetes, szemeteslada)"])
     (slide {:y 120}
            [:pre
             {:style "font-size:65%"}
             "en.kiont(szemetes, szemeteslada)"])
     (slide {:y 160}
            [:pre
             {:style "font-size:65%"}
             "en.megy(haz)"])
     (slide {:y 200}
            [:pre
             {:style "font-size:65%"}
             "en.megmos(en.kez)"])
     (slide {:y 240}
            [:pre
             {:style "font-size:65%"}
             "en.leul(kanape)"])
     (slide {:y 280}
            [:pre
             {:style "font-size:65%"}
             "en.folytat(en.akarmitIsCsinaltam)"])
     )

    (group
     {:x 3000 :y 120
      :scale 0.6}
     (slide {:id "szemet-ember-3"}
            [:pre
             {:style "font-size:65%"} "szemetes = megkeres(szemetes, mosogato_alatt)"])
     (slide {:y 40}
            [:pre
             {:style "font-size:65%"}
             "megfog(szemetes)"])
     (slide {:y 80}
            [:pre
             {:style "font-size:65%"}
             "kivisz(szemetes, szemeteslada)"])
     (slide {:y 120}
            [:pre
             {:style "font-size:65%"}
             "kiont(szemetes, szemeteslada)"])
     (slide {:y 160}
            [:pre
             {:style "font-size:65%"}
             "megy(haz)"])
     (slide {:y 200}
            [:pre
             {:style "font-size:65%"}
             "megmos(kez)"])
     (slide {:y 240}
            [:pre
             {:style "font-size:65%"}
             "leul(kanape)"])
     (slide {:y 280}
            [:pre
             {:style "font-size:65%"}
             "folytat(akarmitIsCsinaltam)"])
     ))

   (group
    {:x 5000 :y -2000
     :rotate 90}
    (slide
     {:id "oop-nyelvek"}
     (fh2 "OOP nyelvek"))

    (slide
     {:y 120 :x -10}
     "Csupasz Ige nincsen")

    (slide
     {:y 120 :x 500}
     "Kompromisszum")
    (slide
     {:y 160 :x 500}
     "Inkonzisztencia"))

   (group
    {:x 6000 :y -2100
     :rotate -90}
    (slide
     {:id "leszarmazas"}
     (fh2 "Leszármazás"))

    (group
     {:scale 0.01}
     (slide
      (fh2 "A gyémánt probléma"))
     (group
      {:scale 0.001}
      (slide
       [:img {:src "img/Diamond_inheritance.svg"
              :width "50%"}])
      (group
       {:x 550
        :y -150}
       (slide
        [:pre
         {:style "font-size:50%;"}
         "class A {
  public methodA() { /* ... */ }
}"])
       (slide
        {:y 80}
        [:pre
         {:style "font-size:50%;"}
"class B extends A {
  public methodA() { /* ... */ }
}"])

       (slide
        {:y 200}
        [:pre
         {:style "font-size:50%;"}
"class C extends A {
  public methodA() { /* ... */ }
}"])

       (slide
        {:y 280}
        [:pre
         {:style "font-size:50%;"}
"class D extends B, C {
}"])

       (slide
        {:y 380}
        [:pre
         {:style "font-size:50%;"}
"D test = new D();
test.methodA();"])))
         )
    ;;
    (group
     {:y 1000}
     (slide
      {:id "if-overflow"}
      (fh2 "Interface burjánzás"))

     (group
      {:scale 0.001}

      (slide
       {}
       [:pre {:style "font-size:50%;"}
        "interface Dateable {
  Long to-ms (Object time);
}"])

      (slide
       {:y 100}
       [:pre {:style "font-size:50%;"}
        "class DateableNumber extends Number implements Dateable {
  Long to-ms (Object time) {
    return (Long) time;
  }
}"])

      (slide
       {:y 220}
       [:pre {:style "font-size:50%;"}
        "class DateableDate extends Date implements Dateable {
  Long to-ms (Object time) {
    return (Long) ((Date) time).getTime ();
  }
}"])

      (slide
       {:y 340}
       [:pre {:style "font-size:50%;"}
        "class DateableCalendar extends Calendar implements Dateable {
  Long to-ms (Object time) {
    return ((DateableDate)((Calendar) time).getTime ()).to_ms ();
  }
}"])

      (group
       {:x 1000
        :rotate 90}

      (slide
       {}
       [:pre {:style "font-size:50%;"}
        "(defprotocol Dateable
  (to-ms [time]))"])

      (slide
       {:y 100}
       [:pre {:style "font-size:50%;"}
        "(extend Number
  Dateable
  {:to-ms identity})"])

      (slide
       {:y 220}
       [:pre {:style "font-size:50%;"}
        "(extend Date
  Dateable
  {:to-ms #(.getTime %)})"])

      (slide
       {:y 340}
       [:pre {:style "font-size:50%;"}
        "(extend Calendar
  Dateable
  {:to-ms #(to-ms (.getTime %))})"]))

      )))

   (group
    {}
    (slide
     {:id "HoF"}
     (fh2 "Egy magasabb Rend"))

    (group
     {:scale 50
      :rotate 0}

     (slide {:id "filters"}
      [:pre
       "(filter even? (range 10))
; => (0 2 4 6 8)

"
"(map (comp - (partial + 3)
             (partial * 2))
     [1 2 3 4])
; => (-5 -7 -9 -11)"])
     ))

   (group
    {:scale 50
     :x 500}
    (slide
     {:id "iterate"}
     [:pre
      "(iterate inc 5
;=> (5 6 7 8 9 ...)"]))

   (group {:x -20000
           :y 3000
           :z 180
           :scale 200
           :rotate 45}
    (slide
     {:id "macros"}
     (fh1 "Makrológia"))

    (group
     {:scale 0.01}
     (slide
      [:pre
       "(defmacro when [test & body]
  `(if ~test (do ~@body)))"])

     (slide
      {:y 120}
      [:pre
       "(defmacro unless [pred a b]
  `(if (not ~pred) ~a ~b))"])

     (slide
      {:y 380}
      [:pre
       "(defmacro ->
  ([x] x)
  ([x form]
    (if (seq? form)
      `(~(first form) ~x ~@(next form))
      (list form x)))
  ([x form & more]
    `(-> (-> ~x ~form) ~@more)))"])

     (group
      {:y 380
       :x 1000}
      (slide
       [:pre
        "(-> 1)"])
      (slide {:x 300}
             [:pre ";=> 1"])


      (slide
       {:y 80}
       [:pre
        "(-> 1
    str)"])
      (slide
       {:x 300
        :y 80}
       [:pre ";=> (str 1)"])

      (slide
       {:y 180}
       [:pre "(-> 1
    (+ 2))"])
      (slide
       {:y 180
        :x 300}
       [:pre ";=> (+ 1 2)"])

      (slide
       {:y 320}
       [:pre "(-> 1
    (+ 2)
    (* 3))"])
      (slide
       {:y 320
        :x 300}
       [:pre ";=> (-> (-> 1 (+ 2)) (* 3))"])
      (slide
       {:y 320
        :x 1000}
       [:pre ";=> (-> (+ 1 2) (* 3))"])
      (slide
       {:y 320
        :x 1600}
       [:pre ";=> (* (+ 1 2) 3)"])
      )
     ))

   (group
    {}
    (slide
     {:id "end-flame"}
     (fh1 {:class "largest"} "Gyász"))

    (group
     {}
     (slide
      (fh2 "Megkötött kezek miatt"))
     (slide
      (fh2 "Korlátozó primitívség"))
     (slide
      (fh2 "Felesleges erőfeszítések"))
     (slide
      (fh2 "Fejlődést akadályozó elem"))
     (slide
      (fh2 "Zsákutca, melyen túlhaladt a világ"))
     (slide
      (fh2 "Hűtlen a kezdeti elvhez"))
     (slide
      (fh2 "Mutációt megengedő"))
     (slide
      (fh2 "Célját nem érheti el"))
     (slide {:id "keruloutak"}
            (fh2 "Kerülőutak!"))
     (group
      {:scale 0.1
       :rotate 45}
      (slide "Frameworkök")
      (slide "Mockolás")
      (slide "Leszármaztatás"))
     (slide
      (fh2 "Elveszett produktivitás"))
     (slide
      (fh2 "Kifordított gondolkodás"))
     (slide
      (fh2 "Lefokozott igék"))
     (slide
      (fh2 "Kompozíció helyett interface és osztály burjánzás"))))

   (group
    {:scale 500}
    (slide
     (fh1 {:class "xx-large"} "Felborult a rend.")))

   (group
    {:scale 8000}
    (slide {:id "end-logo"
            :class "center"}
           [:img {:src "img/mk2.png"
                  :style "height: 75%; width: 75%;"}]))
   
   ))

(comment
  (require '[impressions.all :as a])
  (a/make-impression gyaszbeszed-az-objektumok-felett)
  )
