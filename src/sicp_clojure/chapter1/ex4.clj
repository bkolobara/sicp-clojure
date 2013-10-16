(ns sicp-clojure.chapter1.ex4)

(defn a-plus-abs-b
  [a b]
  ((if (> b 0) + -) a b))
; The *if* returns the plus(+) opretaor if b is greater than 0.
; If b is less than 0 the returned operator is minus(-).
; The returned operator is then used in the expression (? a b).
; Because -(-b) = +b the precedure always returns a + |b|

