(ns sicp-clojure.chapter1.ex6)

(defn new-if
  [predicate then-clause else-clause]
  (cond predicate then-clause
        :else else-clause))

(defn average
  [x y]
  (/ (+ x y) 2))

(defn improve
  [guess x]
  (average guess (/ x guess)))

(defn good-enough?
  [guess x]
  (< (Math/abs (- (Math/pow guess 2) x)) 0.001))

(defn sqrt-iter
  [guess x]
  (new-if (good-enough? guess x)
    guess
    (sqrt-iter (improve guess x)
               x)))

(defn sqrt
  [x]
  (sqrt-iter 1.0 x))

(sqrt 9)
; StackOverflowError in sqrt-iter
; new-if tries to call all arguments (applicative-order evaluation) including
; sqrt-iter and ends up in a infinite recursion.
; The built in if is a special form and only evaluates its arguments if the
; condition is true.

