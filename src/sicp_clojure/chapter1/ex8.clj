(ns sicp-clojure.chapter1.ex8)

(defn improve
  [x y]
  (/ (+ (/ x (Math/pow y 2)) (* 2 y))
     3))

(defn good-enough?
  [guess old-guess]
  (< (Math/abs (- guess old-guess)) 
     (/ guess 10000.0))) ; thousandth of guess

(defn curt-iter
  [guess x old-guess]
  (if (good-enough? guess old-guess)
    guess
    (curt-iter (improve x guess) x guess)))

(defn curt
  [x]
  (curt-iter 1.0 x 2.0)) ; 2.0 so the first good-enough is false

(curt 0.000009)
; 0.0208008 (correct)
(curt 735621000000000)
; 90271.64 (correct)

