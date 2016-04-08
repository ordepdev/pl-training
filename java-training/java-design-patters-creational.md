Design Patterns in Java ~ Creational
====================================
Singleton
---------
 * Only one instance created
 * Guarantees control of a resource
 * Lazily loaded
 * Design: 
  - Class is responsible for lifecycle
  - Static in nature
  - Needs to be thread safe
  - Private instance
  - Private constructor
  - No parameters required for construction
 * Pitfalls
  - Often overused, can cause the app to slow down
  - Difficult to unit test
  - Not careful, not thread-safe
  - Sometimes confused for Factory 

  Singleton
  - singleton : Singleton
  -----------------------
  - Singleton()
  + getInstance() : Singleton

Builder
-------
 * Handles complex contructors
 * Large number of parameters
 * Immutability after creation
 * Example: StringBuilder
 * Design
  - Flexibility over telescoping constructors
  - Static inner class
  - Calls appropriate constructor
  - Negates the need for exposed setters
  * Pitfalls
   - Immutable
   - Inner static class (can be a separate class)
   - Designed first
   - Complexity

   Builder
   -------------
   + buildPart()

        /\
   Concrete Builder
   ----------------
   + buildPart()
   - getResult()

Prototype
---------
 * Avoids costly creation
 * Avoids subclassing
 * Typically doesn't use "new"
 * Often utilizes an Interface
 * Usually implemented with a Registry
 * Example: java.lang.Object#clone()
 * Design
  - Clone/Cloneable
  - Although a copy, each instance is unique
  - Costly construction not handled by client
  - Can still utilize parameters for construction
  - Shallow Copy: keeps the same properties references vs Deep Copy: create new references
 * Pitfalls
  - Sometimes not clear when to use
  - Used with other patterns: Registry
  - Shallow Copy...
  - 
 <<interface>>
 IPrototype
 -------------
 + Clone()
 + DeepCopy()