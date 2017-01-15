(ns parens.core-test
  (:require [clojure.test :refer :all]
            [parens.core :refer :all]))

(deftest validateParenthesesTest
  (testing "Parenthesis nesting validation"
    (is (and (every? true?
                     (map validateParentheses
                          [
                           ""
                           "()"
                           "((()())())"
                           ]))
             (every? false?
                     (map validateParentheses
                          [
                           ")"
                           ")("
                           "())()"
                           "()()())"
                           ]))))))
