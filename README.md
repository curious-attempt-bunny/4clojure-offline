# Purpose

Make it easier and quicker to iterate on [4clojure](http://4clojure.com) problems and track solutions in Git.

# Getting setup

1. Fork this repo.
1. `rm -rf problems` for a clean slate.

# Usage

1. Start up a REPL. E.g. `lein repl`
1. Execute `(load-file "update.clj")` on the REPL to populate the `problems` directory.
1. Edit a problem file to append a solution.
1. Execute `(load-file "update.clj")` on the REPL to test all the solutions to problems.
1. Repeat at will (from step 3).

# Example

Here's an incorrect solution to [problem 5](https://github.com/4clojure/4clojure/blob/0402c227a9f08048561659fdfc90696509b40ad9/src/foreclojure/data_set.clj#L53-L54):

`problems/elementary/05_lists_conj.clj`:
```clojure
; When operating on a list, the conj function will return a new list with one or more items "added" to the front.
; http://www.4clojure.com/problem/5

; (= __ (conj '(2 3 4) 1))
; (= __ (conj '(3 4) 2 1))

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

Not sure what to contribute? Pick an [open issue](https://github.com/curious-attempt-bunny/4clojure-aid/issues)!

# Contributors

* All the authors of problems for [4clojure](https://github.com/4clojure/4clojure#contributors) - see the [commit history for data_set.clj](https://github.com/4clojure/4clojure/commits/develop/src/foreclojure/data_set.clj).
* [Merlyn Albery-Speyer](https://github.com/curious-attempt-bunny).

# License

The source code this repository is available under the Eclipse Public License v 1.0 (the same licensing terms as [4clojure](https://github.com/4clojure/4clojure)). For more information, see `LICENSE.html`.