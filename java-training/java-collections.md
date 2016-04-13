Java Collections
================

Defining and Iterating Collections
----------------------------------
 * Collections of Collections
  - List, Set, Queue, extends Collection
  - SortedSet extends set
  - Deque extends Queue
 * Interfaces
  - Multiple Data Structures
  - Functional Characteristics
  - Prefer as variable type
  - Often has a popular implementation
 * Implementation
  - Specific Data Structure
  - Performance Characteristics
  - Concrete and Instantiable
  - List: ArrayList, LinkedList
  - Set: HashSet
  - SortedSet: TreeSet
  - Queue: PriorityQueue
  - Deque: LinkedList, ArrayDeque
  - Map: HashMap
  - SortedMap: TreeMap
 * How to choose a Collection:
  - Elements are Keyed?
   - No > Elements are Unique?
    - Yes > Order is important?
     - No > Set
     - Yes > SortedSet
    - No > First In, First Out?
     - Yes > Queue, Deque
     - No > Last In, First Out?
      - Yes > Deque
      - No > List
   - Yes > Order is Important?
    - No > Map
    - Yes > SortedMap
 * Collection Interface
  - size(): Get the number of elements in the Collection
  - isEmpty(): True if size() == 0, false otherwise
  - add(element): Add the element at the beginning of this collection
  - addAll(collection): Add all the elements of the argument collection to this collection
  - remove(element): Remove the element from this collection
  - removeAll(collection): Remove all the elements of the argument collection to this collection
  - retainAll(collection): Remove all the elements of this collection not in the argument collection
  - contains(element): True if the element is in this collection, false otherwise
  - containsAll(collection): True if all the elements of the argument collection are in this collection
  - clear(): Remove all elements from this collection

Collections with Iteration Order: Lists
---------------------------------------
  * Key Features
   - void add(int index, E e);
   - E get(int index);
   - E remove(int index);
   - E set(int index, E element);
   - boolean addAll(int index, Collection<? extends E> c);
   - int indexOf(Object o);
   - int lastIndexOf(Object o);
    - Each element has an index
   - List<E> subList(int fromIndex, int toIndex);
    - sublists are views over ranges of lists
    - modifying the view modifies the List
  * Implementations
   - ArrayList
    - Good general purpose implementation
    - Use as default
    - More CPU Cache sympathetic
   - LinkedList
    - Worse performance for many operations
    - Use when adding elements at start
    - Or when adding/removing a lot
  * Performance Comparison
   - ArrayList: get: O(1), add: O(N), contains: O(N), next: O(1), remove: O(N) 
   - LinkedList: get: O(N), add: O(1), contains: O(N), next: O(1), remove: O(1)


