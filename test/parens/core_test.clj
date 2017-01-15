(ns parens.core-test
  (:require [clojure.test :refer :all]
            [parens.core :refer :all]))

;; (deftest a-test
;;   (testing "FIXME, I fail."
;;     (is (= 0 1))))

;; (deftest filterParens-filters-a-character
;;   (testing "Returns a string only containing parens"
;;     (is (re-matches #"^[\(|\)]*$" (filterParens "(a)")))))

;; (deftest filterParens-matches-parens-only-string
;;   (testing "matches a parens only string"
;;     (is (re-matches #"^[\(|\)]*$" (filterParens "()()())))(((()())))")))))

;; (deftest filterParens-matches-empty-string
;;   (testing "matches a parens only string"
;;     (is (re-matches #"^[\(|\)]*$" (filterParens "")))))

(deftest validateParenthesesTest
  (testing "Parenthesis nesting validation"
    (is (and (every? true? (map validateParentheses [
                                                ""
                                                "()"
                                                "((()())())"
                                                     ]))
             (every? false? (map validateParentheses [
                                                    ")"
                                                    ")("
                                                    "())()"
                                                    "()()())"
                                                    ]))))))
