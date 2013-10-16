(ns sicp-clojure.chapter1.ex3)

(defn larger-sum
  [a b c]
  (cond (and (> a c) (> b c)) (+ (* a a) (* b b))
        (and (> a c) (> c b)) (+ (* a a) (* c c))
        :else (+ (* b b) (* c c))))
