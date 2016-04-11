Design Patterns in Java ~ Behavioral
====================================
Chain of Responsibility
-----------------------
 * Concepts
  - Decoupling of sender and receiver
  - Receiver contains reference to next receiver
  - Promotes loose coupling
  - Examples: java.util.logging.Logger#log()
 * Design
  - Chain of receiver objects
  - Handler is Interface based
  - ConcreteHandler for each implementation
  - Each Handler has a reference to the next
  - Handler, ConcreteHandler
 * Pitfalls
  - Handling/Handler guarantee
  - Runtime configuration risk
  - Chain length/performance issues
 * Contrast: Chain
  - Handler is unique
  - Know about Successor
  - Can utilize the Command Pattern
 * Contrast: Command
  - Also unique
  - Encapsulates function
  - Reversible or Trackable in nature

Command Pattern
---------------
 * Concepts
  - Encapsulate request as an Object
  - Object-oriented callback
  - Decouple sender from processor
  - Often used for "undo" functionality
  - Examples: java.lang.Runnable
 * Design
  - 