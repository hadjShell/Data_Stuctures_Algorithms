# Data Structures and Algorithms

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
* 

***

## Resource

* [Big O Cheat Sheet](https://www.bigocheatsheet.com/)
