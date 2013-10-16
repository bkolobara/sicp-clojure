(ns sicp-clojure.chapter1.ex7)

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
  (if (good-enough? guess x)
    guess
    (sqrt-iter (improve guess x)
               x)))

(defn sqrt
  [x]
  (sqrt-iter 1.0 x))

; Small
(sqrt 0.000009)
; correct result O.OO3
; we get 0.0313
;
; Large
(sqrt 735621000000000)
; correct result 27122333.97
; we get 27122333.97 (seems to be correct)

(defn new-good-enough?
  [guess old-guess]
  (< (Math/abs (- guess old-guess)) 
     (/ guess 10000.0))) ; thousandth of guess

(defn new-sqrt-iter
  [guess x old-guess]
  (if (new-good-enough? guess old-guess)
    guess
    (new-sqrt-iter (improve guess x) x guess)))

(defn new-sqrt
  [x]
  (new-sqrt-iter 1.0 x 2.0)) ; 2.0 so the first new-good-enough is false

(new-sqrt 0.000009)
; 0.003 (correct)
(new-sqrt 735621000000000)
; 27122333.97 (correct)
