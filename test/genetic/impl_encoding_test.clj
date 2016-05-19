(ns genetic.impl-encoding-test
  (:require [clojure.test :refer :all]
            [genetic.impl :refer :all]))

(deftest base-conversion
  (testing "Conversion from base-10 to string in base-2"
    (is (= "1011" (binarify 11)))) )

(deftest int-to-bits-test
  (testing "Converts integer to vector of bits"
    (is (-> (int-to-bits 14) (= [1 1 1 0])))))

(deftest bits-to-int-test
  (testing "Converts vector of bits to int"
    (is (-> (bits-to-int [1 1 1 0]) (= 14)))) )

(deftest decode-gene-test
  (testing "Decodes gene of 4 bits into a number."
    (is (-> (bits-to-int [0 1 0 1]) (= 5)))) )
