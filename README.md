# Purpose

Make it easier and quicker to iterate on [4clojure](http://4clojure.com) problems.

# Usage

1. If you want a clean slate: `rm -rf problems`
1. Start up a REPL. E.g. `lein repl`
1. Execute `(load-file "update.clj")` on the REPL to populate the `problems` directory.
1. Edit a problem file.
1. Repeat at will (from step 3).

# Example

Here's an incorrect solution to [problem 5](https://github.com/4clojure/4clojure/blob/0402c227a9f08048561659fdfc90696509b40ad9/src/foreclojure/data_set.clj#L53-L54):

```problems/elementary/05_lists_conj.clj
(= __ (conj '(2 3 4) 1))
(= __ (conj '(3 4) 2 1))

(conj [2 3 4] 1)
```

Running `update.clj` results in each test case being echoed, along with evaluation of the form containing the substition, and if the test passed:

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

# Contributors

* All the authors of problems for [4clojure](https://github.com/4clojure/4clojure#contributors) - see the [commit history for data_set.clj](https://github.com/4clojure/4clojure/commits/develop/src/foreclojure/data_set.clj).
* Merlyn Albery-Speyer 

# License

The source code this repository is available under the Eclipse Public License v 1.0 (the same licensing terms as [4clojure](https://github.com/4clojure/4clojure)). For more information, see `LICENSE.html`.