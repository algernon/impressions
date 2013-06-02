(ns impressions.makro-magia
  (:use [impressive-hiccups.page]
        [impressive-hiccups.element]
        [hiccup.element]))

;; Bevezeto
;;
;; Code is [data]
;; Code is data
;;
;; Mik a makrok?
;;
;; PELDAK:
;;
;; #1: -> + peldak
;; #2: with-open + peldak
;; #3: with-*, binding (garden/src/garden/utils.clj ::
;;             with-output-style)
;;     binding: hiccup, with-base-url
;; #4: syntactic sugar (garden :: defrule)
;; #5: for-loop:
(comment
(defmacro for-loop [[sym init check change :as params] & steps]
  (cond
    (not (vector? params)) 
      (throw (Error. "Binding form must be a vector for for-loop"))
    (not= 4 (count params)) 
      (throw (Error. "Binding form must have exactly 4 arguments in for-loop"))
    :default
      `(loop [~sym ~init value# nil]
         (if ~check
           (let [new-value# (do ~@steps)]
             (recur ~change new-value#))
           value#))))

;; Usage as follows:

(for-loop [i 0, (< i 10), (inc i)]
  (println i))
)

;; cond
;; time
;; or

(defn makro-magia
  []

  (impress
   {:title "Makro mágia"
    :font-uri "http://fonts.googleapis.com/css?family=Titillium+Web"}

   (group
    {:x 0 :y 0}

    (slide {:id "title"}
           (fh1 "Makro mágia")
           [:br]
           (link-to "https://twitter.com/algernoone"
                    "@algernoone")
           [:span {:style "float:right;"}
            "BalaBit"]))

   (group
    {:x 0 :y 1000}

    (slide {:id "code-is"}
           (fh1 {:class "xx-large"} "Code is"))
    (slide {:id "code-is-data-1"
            :y 1000}
           [:img {:src "img/data.jpg"}])
    (slide {:id "code-is-data-2"
            :y 2000}
           (fh1 {:class "xx-large"} "Code is data")))

   (group
    {:x 2000 :y 0}

    (slide {:id "wtf-for"}
           (fh1 "Mire jó a makró?"))

    (group
     {:rotate 270}

     (group
      {}

      (slide {:id "szintaxis"}
             (fh2 "Új szintaxis"))

      (slide
       {:y 120}
       "->")

   (group
    {}

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
      )))

    (group
     {:y 1000}

     (group
      {}

      (slide {:id "kenyelem"}
             (fh2 "Kényelem"))

      (slide
       {:y 120}
       "with-open")

      (slide
       {:y 500}
       [:pre {:style "font-size: 60%"}
        "(defmacro with-open
  [bindings & body]
  (assert-args
     (vector? bindings) \"a vector for its binding\"
     (even? (count bindings)) \"an even number of forms in binding vector\")
  (cond
    (= (count bindings) 0) `(do ~@body)
    (symbol? (bindings 0)) `(let ~(subvec bindings 0 2)
                              (try
                                (with-open ~(subvec bindings 2) ~@body)
                                (finally
                                  (. ~(bindings 0) close))))
    :else (throw (IllegalArgumentException.
                   \"with-open only allows Symbols in bindings\"]))))
"])

      (slide
       {:y 500
        :x 1500
        :id "with-open-example"}
       [:pre "(with-open [foo (File. \"/tmp/foo\")]
  (do-something-with foo))"])
      (slide
       {:y 500
        :x 2500}
       [:pre "=>"])
      (slide
       {:y 500
        :x 3000}
       [:pre "(let [foo (File. \"/tmp/foo\")]
  (try
    (do (do-something-with foo))
    (finally (. foo close))))"])
      ))

    (group
     {:y 2000}

     (group
      {}

      (slide {:id "dynamic-binding"}
             (fh2 "Dinamimus kötés"))

      (slide
       {:y 120}
       "with-base-url")

      (slide
       {:y 500}
       [:pre "(def ^:dynamic *base-url* nil)

(defmacro with-base-url
  [base-url & body]
  `(binding [*base-url* ~base-url]
     ~@body))

(defn to-url
  [uri]

  (str *base-url* \"/\" uri)) "])
      ))

    (group
     {:y 3500}

     (group
      {}

      (slide {:id "syntsugar"}
             (fh2 "Szintaktikai cukorka"))

      (slide
       {:y 120}
       "or, cond")

      (slide
       {:y 400}
       [:pre "(defmacro or
  ([] nil)
  ([x] x)
  ([x & next]
      `(let [or# ~x]
         (if or# or# (or ~@next)))))"])

(slide
 {:y 900}
  [:pre {:style "font-size: 70%;"} "(defmacro cond
  [& clauses]
    (when clauses
      (list 'if (first clauses)
            (if (next clauses)
                (second clauses)
                (throw (IllegalArgumentException.
                         \"cond requires an even number of forms\")))
            (cons 'clojure.core/cond (next (next clauses))))))"

])
      ))
))

(group
 {:rotate 45}

 (slide {:id "Q&A"}
        [:h1 {:class "largest"} "Q&A"]
))

))
