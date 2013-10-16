(ns sicp-clojure.chapter1.ex5)

(defn p
  "Infinite recursion"
  []
  (p))

(defn test
  [x y]
  (if (= x 0)
    0
    y))

(test 0 (p))
; An StackOverflow exception is thrown because Clojure uses applicative-order
; evaluation and tries to evaluate the infinite recursive p procedure before test
; is called.
;
; If the language would use normal-order evaluation test would first expand to
; something like (if (= x 0) 0 (p)) and because x = 0 return 0 and end before
; entering the infinite recursion.

