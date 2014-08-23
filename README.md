# Usage

1. Start up a REPL. E.g. `lein repl`
1. Edit `problem.clj` to include the [4clojure problem](https://github.com/4clojure/4clojure/blob/develop/src/foreclojure/data_set.clj) you want to work on.
2. Edit `problem.clj` to include your desired substitution for the solution.
3. Execute `(load-file "test.clj")` on the REPL.
4. Repeat at will (from step 2 or 1).

# Example

Here's an incorrect solution to [problem 5](https://github.com/4clojure/4clojure/blob/0402c227a9f08048561659fdfc90696509b40ad9/src/foreclojure/data_set.clj#L53-L54):

```problem.clj
(= __ (conj '(2 3 4) 1))
(= __ (conj '(3 4) 2 1))

(conj [2 3 4] 1)
```

Running `test.clj` results in each test case being echoed, along with what first form element evaluated to, and if the test passed:

```clojure
"(= __ (conj '(2 3 4) 1))"
=> [2 3 4 1]
false

"(= __ (conj '(3 4) 2 1))"
=> [2 3 4 1]
false
```

# Contributions

Contributions are welcome. Open a pull request!

