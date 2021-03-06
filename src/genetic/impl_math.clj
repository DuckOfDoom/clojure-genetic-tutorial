(in-ns 'genetic.impl)

(defn random-chromosome
  "Produces a random sequence of bits"
  [n]
  (take n (repeatedly #(rand-int 2))))

(defn calculate-average-fitness
  "Calculates average fitness across the population"
  [state]
  (/ (reduce + (map :fitness state)) (count state)))

(defn calculate-fitness
  "Calculate fitness for our chromosome"
  [value target-value]
    (/ 1.0 (Math/abs (- value target-value))))

(defn calculate-expression
  "Calculate the result of our expression in string form.
  Converts infix to valid Clojure code."
  [infix-expresson]
  (let [expr (try (from-string infix-expresson)
                  (catch Exception e (str "Caught Exception: " (.getMessage e)) nil))]
    (if (-> expr nil?)
      Double/POSITIVE_INFINITY
      (try (expr)
           (catch ArithmeticException e (str "Division By Zero!") Double/POSITIVE_INFINITY)))))

