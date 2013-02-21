(defn display
  [msg]

  (javax.swing.JOptionPane/showMessageDialog nil msg))

;; Delays

(def pd:delay (delay (do (Thread/sleep 5000) 5)))
(def pd:delay-map {:some-value "Hello"
                   :some-delay (delay (do (Thread/sleep 5000) "World"))})

(def pd:ex (delay (do (Thread/sleep 5000) (throw (Exception. "jajj")))))

;; {:username "akarmi",
;;  :tweets (delay ...)}

(comment
  (display (deref pd:ex))
  (display (pr-str pd:delay))
  (display (realized? pd:delay))
  (display @pd:delay)
  (display (:some-value pd:delay-map))
  (display @(:some-delay pd:delay-map))
  (display (str (:some-value pd:delay-map) " " @(:some-delay pd:delay-map)))
  )

;; Futures
(def pd:future (future (do (Thread/sleep 5000) 5)))
(def pd:future-map {:some-value "Hello"
                    :some-future (future (do (Thread/sleep 5000) "World"))})

(def pd:f-ex (future (throw (Exception. "jujj"))))

(display @pd:f-ex)

(comment
  (display (pr-str pd:future))
  (display (realized? pd:future))
  (display @pd:future)
  (display (deref pd:future 1 :ize))
  (display (:some-value pd:future-map))
  (display @(:some-future pd:future-map))
  (display (str (:some-value pd:future-map) " " @(:some-future pd:future-map)))
  )

;; Promises
(def pd:promise (promise))

(defmacro thr
  [& body]

  `(.start (Thread. (fn [] ~@body))))

(comment
  (do
    (Thread/sleep 1000)
    (deliver pd:promise 1))

  (thr (Thread/sleep 5000) (deliver pd:promise "Hello vilag!"))
  (thr (deliver pd:promise (Exception. "hello")))
  
  (display (pr-str pd:promise))
  (display (realized? pd:promise))
  (display @pd:promise)
  (deliver pd:promise 5)
  (display (deref pd:promise 1 :nyuff))
  )

