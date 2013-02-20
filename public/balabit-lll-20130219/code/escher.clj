(def escher-seq
  (lazy-seq
   (lazy-seq
    (if (seq escher-seq)
      nil
      (list 42)))))

(comment
  escher-seq
  )
