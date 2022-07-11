# Data Structures and Algorithms

***

## ToC

* [Introduction](# Introduction)
* [Big O](# Big O)
* **Data Structures**
  * [Array](# Array)

***

## Introduction

* Data structure: method to store information

* Algorithm: method for solving a problem

  >Algorithms + Data Structures = Programs. By Niklaus Wirth.

* Not all problems can be solved, e.g. halting problem

* ```mermaid
  graph LR;
  Problem --> Idea
  Idea --> Algorithm
  Algorithm --> Program
  ```

* *My comprehension: data structure is the combination of the data which stores the value and the metadata which maintains the structure.*

* Basic operations on data structures

  * Accessing
  * Insertion
  * Deletion
  * Traversal
  * Searching
  * Sorting
  * ![DS_Operation_Performance](D:\OneDrive\NCL\Extracurricular content\DSA\imgs\DS_Operation_Performance.png)

* Pseudo code

  * Describe an algorithm

  * Should be abstract

    * Ignores unimportant details
    * Allows clear presentation of key idea
    * Simplifies analysis of a proposed solution

  * Templates

    ```markdown
    Algorithm
    Inputs
    Returns
    Variables (local)
    Begin
    
    End
    ```

    * Not rigid, different among various organizations

* All have **trade-offs**

***

## Big O

* Analyze an algorithm

  * Need to measure performance of different algorithms to allow us to compare them
  * Interested in efficiency of an algorithm
    * **Time**: how fast does an algorithm run
    * **Space**: how much memory is required
  * Experimental approach: limited
  * Theoretical approach: Complexity analysis

* Big O Notation

  * Give an approximately **upper bound** (worst case) on an algorithm complexity
  * `O(f(N))`: indicate the approximate number of **operations** required by an algorithm for input size `N`
  * ![BIG_O](D:\OneDrive\NCL\Extracurricular content\DSA\imgs\BIG_O.png)

  * Big O is a classification system that groups together algorithms that have similar performance. Enable us to quickly compare different algorithms
  * Extra effort to calculate exact bounds is normally unnecessary (is sometimes)
  * Two algorithms with same Big O performance may not behave exactly the same in practice
  * Rules
    * Only consider dominant arithmetic terms as input size `N` approaches infinity
    * Adding, subtracting, multiplying, or dividing a Big O performance bound by a constant factor does not change it, doesn't matter how big the constant factor is
    * Different terms for multiple inputs
    * `O(f(N) + g(N)) = O(max(f(N), g(n)))`
    * `O(f(N)) * O(g(N)) = O(f(N) * g(N))`

* Big Omega Ω: lower bound on performance (best case)

* Big Theta θ: bounded above and below (average case)

* Algorithm analysis case

  * Best case; Worst case; Average case (Don't constraint the input, still be infinity)
  * Normally focus on worst case as this gives us an upper bound
  * Average case can be useful but hard to calculate and assume random data
  * Best case seen as least useful but can provide a good indication of when to use a particular algorithm

***

## Array

* Organizes items sequentially
* Sometimes called list
* Elements are stored in continuous memory, accessing is `O(1)`
* Static array and Dynamic array
  * Dynamic array allocate new memory and copy the old array
  * Append in static array is `O(1)`, in dynamic array is `O(n)`

* Pros
  * Fast lookup
  * Fast push / pop
  * Ordered

* Cons
  * Slow insertion
  * Slow deletion
  * Fixed size (static array)


***

## Linked List

* A linear collection of data elements, consisting of a group of nodes which together represent a sequence (**ordered**)
* Order is not given by elements' physical placement in memory
* Nodes have reference to adjacent nodes
* Head node, tail node
* `NULL` terminated
* **Sentinel nodes**
  * In some implementations an extra 'sentinel' or 'dummy' node may be added before the first data record or after the last one
  * This convention simplifies and accelerates some list-handling algorithms, by ensuring that all links can be safely dereferenced and that every list (even one that contains no data elements) always has a "first" and "last" node
* Pros
  * Fast insertion
  * Fast deletion
  * Ordered
  * Flexible size
* Cons
  * Slow lookup
  * More memory

### Singly Linked List

* ![singly_linked_list](D:\OneDrive\NCL\Extracurricular content\DSA\imgs\singly_linked_list.svg)

### Doubly Linked List

* ![doubly_linkede_list](D:\OneDrive\NCL\Extracurricular content\DSA\imgs\doubly_linkede_list.svg)
* Single vs. Double
  * Single is a little faster, uses less memory
  * Double can be traversed from both directions

***

## Hash Table

* Also called Hash map, Dictionary

* A data structure which can *map keys to values*. A hash table uses a *hash function* to compute an index into an array of buckets or slots, from which the desired value can be found

* Implement a linked list

* Basic idea: *Perfect hashing*

  * Suppose key values within range `0` to `N-1` and use an array of size `N` to store records
  * Then a key can correspond directly to the array location of its associated record
  * Searching and insertion would require only a single array access and thus `O()1`
  * However, perfect hashing is rarely practical to implement

* Hash function

  * One-way function

  * Idempotent

  * ```mermaid
    graph LR;
    K((Key)) --> H[Hash Function]
    H --> L((location))
    ```

  * Two important issues in Hashing (**防，治思想**)

    * How to define a good hash function?
      * Need to ensure hash function is reasonably random, which means key will be evenly distributed and so reduces key collisions
    * How to resolve key collisions?

***

## Resource

* [Big O Cheat Sheet](https://www.bigocheatsheet.com/)
* <https://github.com/trekhleb/javascript-algorithms>
* <https://github.com/TheAlgorithms/Java>
