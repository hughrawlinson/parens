(ns parens.core)

(defn filterChars
  "Filter a string by a collection of chars"
  [string characters]
  (filter (fn [character]
            (some #(= character %) characters)) string))

(defn filterParens
  [string]
  (filterChars string "()"))

(defn calcParenState [word] (reduce (fn [ac el]
                                      (case el
                                        \( (cons (+ (first ac) 1) ac)
                                        \) (cons (- (first ac) 1) ac)
                                        )) [0] (filterParens word)))

(defn validateParentheses
  "Validate that parentheses characters are properly nested in a string"
  [word]
  (let [parenVals (calcParenState word)]
    (and (every? #(>= % 0) parenVals)
         (= 0 (first parenVals)))))
