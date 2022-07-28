# Data Structures and Algorithms

***

## ToC

* [Introduction](# Introduction)
* [Big O](# Big O)
* **Data Structures**
  * [Array](# Array)
  * [Linked List](# Linked List)
  * [Stack & Queue](# Stack & Queue)

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
  * ![DS_Operation_Performance](https://raw.githubusercontent.com/hadjShell/Data_Stuctures_Algorithms/main/imgs/DS_Operation_Performance.png?token=GHSAT0AAAAAABNGJ6OK25Z5YUNY7SD7TDRWYXCSH7Q)

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
  * ![BIG_O](https://raw.githubusercontent.com/hadjShell/Data_Stuctures_Algorithms/main/imgs/BIG_O.png?token=GHSAT0AAAAAABNGJ6OKMZMAAS7CXXJAPW5IYXCSHVQ)

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
* Sometimes called **list**
* Elements are stored in continuous memory, **accessing is `O(1)`**
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
* **Quick slow pointers**
  * Quick first move couple of steps, and then slow start to move too
  * Quick and slow move in different speed at the same time
  * Quick change the speed when some conditions are met

* Pros
  * Fast insertion
  * Fast deletion
  * Ordered
  * Flexible size
* Cons
  * Slow lookup
  * More memory

### Singly Linked List

* ![singly_linked_list](https://raw.githubusercontent.com/hadjShell/Data_Stuctures_Algorithms/main/imgs/singly_linked_list.svg?token=GHSAT0AAAAAABNGJ6OLI7HZSWGWFUV7HSE2YXCSJKA)

### Doubly Linked List

* ![doubly_linkede_list](https://raw.githubusercontent.com/hadjShell/Data_Stuctures_Algorithms/main/imgs/doubly_linkede_list.svg?token=GHSAT0AAAAAABNGJ6OKIV7ZNLW2N27T7JDQYXCSJCA)
* Single vs. Double
  * Single is a little faster, uses less memory
  * Double can be traversed from both directions

***

## Stack & Queue

* Stack

  * A list of objects

  * Three principle operations

    * **push**, which adds an element to the collection
    * **pop**, which removes the most recently added element that was not yet removed
    * **peek**, which accesses the top without modifying the stack

    > Limitation of functionalities is sometimes a better choice

  * **LIFO**

* Queue

  * A list of object
  * Four principle operations
    * **enqueue**, which adds an element to the rear terminal position
    * **dequeue**, which removes the element from the front terminal position
    * **front**, which accesses the front item from the queue
    * **rear**, which accesses the last item from the queue
  * **FIFO**

* Both can be implemented by *Array* or *Linked list*, each way has pros and cons

  * Queue normally is not implemented by *Array*
  * Queue can be implemented by *Stack* (Leetcode 232)

* Pros

  * Fast operations
  * Limited operations
  * Ordered

* Cons

  * Slow lookup

***

## Hash Table

* Also called *Hash Map*, *Dictionary*

* A data structure which can *map keys to values*. A hash table uses a *hash function* to compute an index into an array of buckets or slots, from which the desired value can be found

* Implement an array of `Node` with linked list (or self balancing BST)

* Basic idea: *Perfect hashing*

  * Suppose key values within range `0` to `N-1` and use an array of size `N` to store records
  * Then a key can correspond directly to the array location of its associated record
  * Searching and insertion would require only a single array access and thus `O(1)`
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

* Collision resolution strategies

  * Separate Chaining
    * 

  * Linear Probing

* Pros

  * Fast operations: search, insertion, deletion take `O(1)` on average
  * Flexible keys: most data types can be used for keys, as long as they're hashable

* Cons

  * Slow worst case: operations take `O(N)` in the worst case
  * Unordered: keys are not stored in a special order
  * Single-directional lookups: look up the value for a given key is `O(1)`, but look up the key for a given value is `O(N)`
  * Not cache-friendly: usage of linked list

* Performance of hash map

  * Initial Capacity
    * It is the capacity of HashMap at the time of its creation (It is the number of buckets a HashMap can hold when the HashMap is instantiated)

  * Load Factor
    * It is the percent value of the capacity after which the capacity of HashMap is to be increased (It is the percentage fill of buckets after which Rehashing takes place)

  * Threshold
    * Load Factor × Initial Capacity

  * Rehashing
    * It is the process of doubling the capacity of the HashMap after it reaches its Threshold

  * If the initial capacity is kept higher then rehashing will never be done. But by keeping it higher increases the time complexity of iteration. So it should be chosen very cleverly to increase performance. The expected number of values should be taken into account to set the initial capacity. The most generally preferred load factor value is 0.75 which provides a good deal between time and space costs. The load factor’s value varies between 0 and 1.

* When Hash Map operations cost `O(N)` time?

  * Hash collisions
    * If all our keys caused hash collisions, we'd be at risk of having to walk through all of our values for a single lookup (one big linked list). This is unlikely, but it could happen

  * Dynamic array resizing
    * Suppose we keep adding more items to our hash map. As the number of keys and values in our hash map exceeds the number of indices in the underlying array, hash collisions become inevitable. To mitigate this, we could expand our underlying array whenever things start to get crowded. That requires allocating a larger array and rehashing all of our existing keys to figure out their new position—O(n) time.


***

## Resource

* [Big O Cheat Sheet](https://www.bigocheatsheet.com/)
* <https://github.com/trekhleb/javascript-algorithms>
* <https://github.com/TheAlgorithms/Java>
