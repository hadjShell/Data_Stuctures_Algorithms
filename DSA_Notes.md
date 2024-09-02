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
    * **Space**: how much memory is required **simultaneously**
  * Experimental approach: limited
  * Theoretical approach: Complexity analysis

* Big O Notation

  * Give an approximately **upper bound** on an algorithm complexity
  * `O(f(N))`: indicate the approximate number of **operations** required by an algorithm for input size `N`
  * ![BIG_O](https://raw.githubusercontent.com/hadjShell/Data_Stuctures_Algorithms/main/imgs/BIG_O.png?token=GHSAT0AAAAAABNGJ6OKMZMAAS7CXXJAPW5IYXCSHVQ)

  * Big O is a classification system that groups together algorithms that have similar performance. Enable us to quickly compare different algorithms
  * Extra effort to calculate exact bounds is normally unnecessary (is sometimes)
  * Two algorithms with same Big O performance may not behave exactly the same in practice
  * Big Omega Ω: lower bound on performance
  * Big Theta θ: bounded above and below

* Rules
  * Drop the non-dominant arithmetic terms

    * `O(f(N) + g(N)) = O(max(f(N), g(n)))`
    * `O(f(N)) * O(g(N)) = O(f(N) * g(N))`

  * Drop the constants

    * Adding, subtracting, multiplying, or dividing a Big O performance bound by a constant factor does not change it, doesn't matter how big the constant factor is

  * Different terms for multiple inputs

  * Functional call can cost more than `O(1)`

  * > Generally speaking, when you see an algorithm with multiple recursive calls, you're looking at exponential runtime

  * We can also approach the runtime by thinking about what the code is supposed to be doing

* Algorithm analysis case

  * Best case; Worst case; Average case (Don't constraint the input, still be infinity)
  * Normally focus on worst case as this gives us an upper bound
  * Average case can be useful but hard to calculate and assume random data
  * Best case seen as least useful but can provide a good indication of when to use a particular algorithm

***

## Data Structures

### Array

* Organizes items sequentially
* Sometimes called **list**
* Elements are stored in continuous memory, **accessing is `O(1)`**
* Array's index is actually a **pointer**
* Array can be empty, i.e. no elements, no memory allocated
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

### Linked List

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

#### Singly Linked List

* ![singly_linked_list](https://raw.githubusercontent.com/hadjShell/Data_Stuctures_Algorithms/main/imgs/singly_linked_list.svg?token=GHSAT0AAAAAABNGJ6OLI7HZSWGWFUV7HSE2YXCSJKA)

#### Doubly Linked List

* ![doubly_linkede_list](https://raw.githubusercontent.com/hadjShell/Data_Stuctures_Algorithms/main/imgs/doubly_linkede_list.svg?token=GHSAT0AAAAAABNGJ6OKIV7ZNLW2N27T7JDQYXCSJCA)
* Single vs. Double
  * Single is a little faster, uses less memory
  * Double can be traversed from both directions

***

### Stack & Queue

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

* Pros

  * Fast operations
  * Limited operations
  * Ordered

* Cons

  * Slow lookup

***

### Hash Table

* Also called *Hash Map*, *Dictionary*

* A data structure which can *map keys to values*. A hash table uses a *hash function* to compute an index into an array of buckets or slots, from which the desired value can be found

* Key has to be unique, value can be the same

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
    * Build a linked list for each of the table position

  * Linear Probing

    * No linked list, just array

    * When a key collides with a previously inserted key we simply place it in the next available unused location to the right (if reaching the end go the beginning)

      > There is possibly a key collision in a sequential non-null elements between `null` and `null`

    * Searching

      * Find the position using hash function
      * Search from here upwards through array looking for key
      * Searching is deemed unsuccessful if we reach an empty location or end up back where we started

    * Deletion

      * Cannot directly delete the element (new `null` may affect searching)
      * Two possible approaches
        * Using a special *linking* (empty character) to mark a deletion - searching does not stop if this character is encountered
          * Simple but can be slow for searching
        * Delete the contiguous occupied cells to the right and reinsert them
          * More costly but faster searching

* Pros

  * Fast operations: search, insertion, deletion take `O(1)` on average
  * Flexible keys: most data types can be used for keys, as long as they're hashable

* Cons

  * Slow worst case: operations take `O(N)` in the worst case
  * **Unordered**: keys are not stored in a special order
  * Single-directional lookups: look up the value for a given key is `O(1)`, but look up the key for a given value is `O(N)`
  * Not cache-friendly: usage of linked list with separate chaining solution

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

### Tree

* Tree is a data structure where the data is organized in a hierarchical structure. There should be one root node (which does not have any parent) and all subsequent nodes are represented as children of the root node and its children

* If a node has at least one child, it is called `internal` node and nodes with no children are called `leaf` nodes

* *Perfect binary tree*: every node except leaf nodes has exactly two child nodes

* *Full binary tree*: every node except leaf nodes has zero or two child nodes

* *Complete binary tree*: a binary tree in which every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible

* Traversal

  * DFS

    * **Three different orders represents three different times when the specific operation is operating on the node**

      * Preorder: operates when the procedure call of current node is just pushed onto the stack
      * Inorder: operates when the left subtree's operation is executed and the right subtree's operation is about to executed
      * Postorder: operates when the the procedure call of current node is about to be popped out from the stack

    * ```java
      void traverseDFS(TreeNode root) {
          if (root == null) {
              return;
          }
          // preorder
          traverse(root.left);
          // inorder
          traverse(root.right);
          // postorder
      }
      			  1
          2    	  3
        4   5   6   7
      
      // Example: 	[1,2,3,4,5,6,7]
      // preorder: 	[1,2,4,5,3,6,7]
      // inorder:		[4,2,5,1,6,3,7]
      // postorder:	[4,5,2,6,7,3,1]
      ```

  * BFS

    * ```java
      void traverseBFS(TreeNode root) {
          if (root == null)
              return;
        
          Deque<TreeNode> q = new ArrayDeque<>();
          q.add(root);
          int depth = 1;
          while (!q.isEmpty()) {
              int sz = q.size();
              for (int i = 0; i < sz; i++) {
                  TreeNode cur = q.remove();
                  System.out.println("depth = " + depth + ", val = " + cur.val);
                  if (cur.left != null) 
                      q.add(cur.left);
                  if (cur.right != null)
                      q.add(cur.right);
              }
              depth++;
          }
      }
      ```


#### Binary Search Tree

* A binary tree that `left child node < parent node < right child node`

* Searching, insertion, deletion - `O(log N)` for balanced BST, `O(N)` for unbalanced BST
  * For a perfect binary tree, its level is equal to `log (N + 1)`, which is approximately `log N`

  * ```markdown
    Algorithm 	findBST
    Inputs			c: Pointer; key: Integer
    Returns 		Pointer
    
    Begin
    	if c = NULL then return NULL
    	else
    		if c.key() = key then return c
    		if c.key() > key then
    			return findBST(c.leftPTR(), key)
        else
        	return findBST(c.rightPTR(), key)
    End
    
    c - pointer to current node
    c.key() - value at node c
    c.leftPTR() - pointer to left node at c
    ```

* Deletion
  * Node with at most one subtree
    * Simple delete and change the pointer if needed
  * Root node & nodes that have two subtrees
    * Marked as deleted, or
    * Minimum in right subtree, or
      * Find next highest node N, i.e., go right then left as far as you can
      * Delete N (having at most one subtree)
      * Replace node deleting by node N
    * Maximum in left subtree

#### AVL Tree

* A self-balancing BST

#### Red-Black Tree

* A self-balancing BST

***

### Binary Heap

### Priority Queue

### Trie

### Graph

* A graph consists of a collection of objects (*nodes* / *vertex*) and connections between them (*edges*)

* A superset of non-binary tree

* Types

  * Directed graph
  * Undirected graph
  * Weighted graph
  * Unweighted graph
  * Cyclic graph
  * Acyclic graph

* Implementations

  * Adjacent list

    * Vertices are stored as records or objects, and every vertex stores a list of adjacent vertices

  * Adjacent matrix

    * A two-dimensional matrix, in which the rows represent source vertices and columns represent destination vertices
    * Data on edges and vertices must be stored externally. Only the cost for one edge can be stored between each pair of vertices

  * Incidence matrix

    * A two-dimensional matrix, in which the rows represent the vertices and columns represent the edges
    * The entries indicate the incidence relation between the vertex at a row and edge at a column

  * |                                                              |                        Adjacency list                        |                       Adjacency matrix                       |                       Incidence matrix                       |
    | :----------------------------------------------------------- | :----------------------------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: |
    | Store graph                                                  |                         $O(|V|+|E|)$                         |                          $O(|V|^2)$                          |                        O(\|V\|⋅\|E\|)                        |
    | Add vertex                                                   |                            $O(1)$                            |                          $O(|V|^2)$                          |                        O(\|V\|⋅\|E\|)                        |
    | Add edge                                                     |                            $O(1)$                            |                            $O(1)$                            |                        O(\|V\|⋅\|E\|)                        |
    | Remove vertex                                                |                           $O(|E|)$                           |                          $O(|V|^2)$                          |                        O(\|V\|⋅\|E\|)                        |
    | Remove edge                                                  |                           $O(|V|)$                           |                            $O(1)$                            |                        O(\|V\|⋅\|E\|)                        |
    | Are vertices *x* and *y* adjacent (assuming that their storage positions are known)? |                           $O(|V|)$                           |                            $O(1)$                            |                           O(\|E\|)                           |
    | Remarks                                                      | Slow to remove vertices and edges, because it needs to find all vertices or edges | Slow to add or remove vertices, because matrix must be resized/copied | Slow to add or remove vertices and edges, because matrix must be resized/copied |

    Adjacency lists are generally preferred for **sparse graphs**, while an adjacency matrix is preferred for **dense graphs**

  * The time complexity of operations in the adjacency list representation can be improved by storing the sets of adjacent vertices in more efficient data structures, such as *hash tables* or *balanced BST*

***

## Algorithms

### Recursion

* A function being defined is applied within its own definition
* Stack overflow: keep invoking function without end condition until too much memory is used on the call stack
* Base case & Recursive case
* Anything done with a recursion **CAN** be done iteratively
* Divide and Conquer

***

### Sorting

* Comparison sort and non-comparison sort
* Comparison sort cannot really beat O(N*logN)

#### Bubble Sort

* Find the biggest element in the unsorted array and bubble it up to the end

  * unsorted + sorted

* ```markdown
  Algorithm 	bubbleSort
  Inputs			A: Array of Integers
  Variables		n, i: Integer; swapped: Boolean
  
  Begin
  	n := size(A)
  	do
  		swapped := false
  		for i := 1 to n - 1 do
  			if A[i - 1] > A[i] then 
  				swap(A[i-1], A[i])
  				swapped := true
      n := n - 1
  	while not swapped
  End
  ```

* Only for educational purpose

* Performance

  * Best case: O(N) for a sorted array
  * Worst case: O(N^2^)
  * Average case: O(N^2^)
  * Space: O(1)

#### Selection Sort

* Scan and select the smallest element in the unsorted array and swap it with the leftmost unsorted element

  * sorted + unsorted

* ```markdown
  Algorithm		selectionSort
  Inputs			A: Array of Integers
  Variables		i, j, smallest: Integers
  
  Begin
  	for i := 0 to size(A) - 1 do
  		smallest := i
  		for j:= i + 1 to size(A) - 1 do
  			if A[j] < A[i] then
  				smallest = j
      swap(A[i], A[smallest])
  End
  ```

* Only for educational purpose
* Performance
  * O(N^2^)
  * Space: O(1)

#### Insertion Sort

* Consider one element at a time and insert it into its correct positiion in the sorted array

  * sorted + unsorted

* ```markdown
  Algorithm 	insertionSort
  Inputs			A: Array of Integers
  Variables		i, j, key: Integers
  
  Begin
  	for i:= 1 to size(A) - 1 do
  		key := A[i]
  		j := i
  		while j > 0 and key < A[j - 1] do
  			A[j] := A[j - 1]
  			j := j - 1
      A[j] := key
  End
  ```

* Works well for small array (typically between 7 and 50 elements) or nearly sorted array

* Performance

  * Best case: O(N) for a sorted array
  * Worst case: O(N^2^)
  * Average case: O(N^2^)
  * Space: O(1)

* Refinement

  * Add a sentinel element make it the smallest
  * So that the comparison `j > 0` can be omitted in the beginning of the loop

#### Merge Sort

* Idea

  * Divide the unsorted list into *n* sublists, each containing one element (a list of one element is considered sorted)
  * Repeatedly merge sublists to produce new sorted sublists until there is only one sublist remaining. This will be the sorted list

* ```markdown
  Algorithm		mergeSort
  Inputs			A: Array of Integers
  Variables		i: Integer; left, right: Array of Integers
  
  Begin
  	if size(A) <= 1 then	return A
  	
  	left := empty array
  	right := empty array
  	for i:= 0 to size(A) - 1 do
    	if i < size(A) / 2 then
    		left.add(A[i])
      else
      	right.add(A[i])
    
    left := mergeSort(left)
    right := mergeSort(right)
    
    return merge(left, right)  
  End
  ```

* ```markdown
  Algorithm		merge
  Inputs			left, right: Array of Integers
  Variables		result: Array of Integers
  
  Begin
  	result := empty list
  
  	while left is not empty and right is not empty do
      if first(left) ≤ first(right) then
      	append first(left) to result
        left := rest(left)
      else
        append first(right) to result
        right := rest(right)
        
  	while left is not empty do
        append first(left) to result
        left := rest(left)
  	while right is not empty do
        append first(right) to result
        right := rest(right)
  	return result
  End
  ```

* Overall great but requires more space, stable sort

* Performance

  * O(N*logN)
  * Space: O(N)

#### Quick Sort

* Idea

  * Choose rightmost value in the array as pivot v
  * Rearrange (partition) the array so that v is in its correct place, i.e.
    * Every element to left is smaller than v
    * Every element to right is larger than v
  * Recursively apply above to left hand side and right hand side of the array
  * When a partition contains only one element then the recursion ends

* ```markdown
  Algorithm 	quickSort
  Inputs			A: Array of Integers
  Variables		p: Integer
  
  Begin
  	if (R > L) then
  		p := partition(A, L, R)
  		quickSort(A, L, p - 1)
  		quickSort(A, p + 1, R)
  End
  
  p - index of the pivot in the correct place
  ```

* ```markdown
  Algorithm 	partition
  Inputs			A: Array of Integers; L, R: Integer
  Variables		pL, pR, v: Integer
  Return			Integer
  
  Begin
  	v := A[R]
  	pL := L; pR := R
  	while pL < pR do
  		while A[pL] < v do 
  			pL := pL + 1
  		while A[pR] >= v and pR > L do
  			pR := pR - 1
      if pL < pR then
      	swap(A[pL], A[pR])
  	swap(A[pL], A[R])
  	return pL
  End
  ```

* Practically faster than Merge Sort and Heap Sort, in-place sort

* Performance

  * Best case, Average case: O(N*logN)
  * Worst case: O(N^2^)
    * Occurs when the partition size are as uneven as possible
    * Bad choice of pivot
    * Sorted array when the last element is chosed as pivot
  * Space: O(logN)

* Refinement

  * Smarter choice of pivot

  * Leaves array nearly sorted and then complete sorting using Insertion Sort efficiently

  * ```markdown
    Begin
    	if (R - L > few) then
    		p := partition(A, L, R)
    		quickSort(A, L, p - 1)
    		quickSort(A, p + 1, R)
    End
    ```

  * Experimentation suggests `few` is between 5 and 25

#### Heap Sort



#### Counting Sort

* Integer sorting algorithm
* Works best when the range of numbers for each array element is very small

#### Radix Sort

* Integer sorting algorithm

#### Bucket Sort

***

### Searching

* Fundamental task needed in most computing systems

#### Sequential Search

#### Binary Search

* Divide and conquer

* Works on a sorted array

* ```markdown
  Algorithm 	binarySearch
  Inputs			A: Array of Integers; key: Integer; L, R: Integer
  Variables		m: Integer
  Return			Integer
  
  Begin
  	if R < L then return -1
  	m := (R + L) / 2
  	if key = A[m] then return m
  	else if key > A[m] then
  		return binarySearch(A, key, m + 1, R)
  	else
    	return binarySearch(A, key, l, m - 1)
  End
  ```

* Performance

  * Best case: O(1)
  * Worst case: O(logN)

***

### Greedy

* A greedy algorithm is a problem-solving technique that makes the best local choice at each step in the hope of finding the global optimum solution
* 



***

## Resource

* [Big O Cheat Sheet](https://www.bigocheatsheet.com/)
* <https://github.com/trekhleb/javascript-algorithms>
* <https://github.com/TheAlgorithms/Java>
