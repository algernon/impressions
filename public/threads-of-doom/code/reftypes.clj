(defn display
  [msg]

  (javax.swing.JOptionPane/showMessageDialog nil msg))

(defmacro thr
  [& body]

  `(.start (Thread. (fn [] ~@body))))

;; Atoms

(def rt:atom-n (atom 0))
(def rt:atom-retry-cnt (atom 0))

(defn rand-inc
  [x]

  (Thread/sleep (* (rand-int 5) 1000))
  (swap! rt:atom-retry-cnt inc)
  (send ...)
  (inc x))

(comment
  (display @rt:atom-n)
  (swap! rt:atom-n inc)
  (swap! rt:atom-n #(+ 2 %))
  (reset! rt:atom-retry-cnt 0)
  (reset! rt:atom-n 0)
  (dotimes [i 15]
    (thr (swap! rt:atom-n rand-inc))
    )
  (display @rt:atom-retry-cnt)
  )

;; Refs

(def rt:ref-1 (ref 1))
(def rt:ref-2 (ref 2))

(comment
  (dosync
   (alter rt:ref-1 inc)
   (alter rt:ref-2 inc))
  (display @rt:ref-1)
  (display @rt:ref-2)

  ;; commute
  )

;; Agents
(def agent-a (agent 0))
(send agent-a #(do (println "foobar") (inc %)))
(display @agent-a)
(realized? agent-a)




;; send, send-off
