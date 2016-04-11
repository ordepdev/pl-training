Design Patterns in Java ~ Creational
====================================
Adapter Pattern
---------------
* Concepts
 - Plug adaptor
 - Convert interface into another interface
 - Way to talk with legacy code
 - Client, Adapter, Adaptee
 - Examples: Arrays -> Lists, Streams
* Design
 - Client centric
 - Integrate new with old
 - Interface, but not required
* Pitfalls
 - Not a lot!
 - Don't complicate
 - Multiple Adapters
 - Don't add functionality: turns into a decorator

 Client
 ------
 + doSomething()
   /\
 <<interface>>
 Adapter
 -------------
 + doThis()
   /\
 LegacyProduct
 -------------
 + doThat()

Bridge Pattern
--------------
 * Concepts
  - Decouple Abstraction and implementation
  - Encapsulation, Composition, Inheritance
  - Changes in Abstraction won't affect client
  - Details won't be right
 * Design
  - Interfaces and Abstract classes
  - Composition over Inheritance
  - More than Composition
  - Expect change from both sides
  - Abstraction, Implementor, Refined Abstraction, Concrete Implementor
 * Pitfalls
  - Increases complexity
  - Conceptually dificult to plan
  - More than just OO
  - What goes where
 * Contrast: Bridge
  - Designed upfront
  - Abstraction and implementation vary
  - Built in advance
  - Complex
 * Contrast: Adapter
  - Works after the code is designed
  - Works well on legacy applications
  - Retrofitted: try latter
  - Provide different interface

Composite Pattern
-----------------
 * Concepts
  - Components represent part or whole structure
  - Compose objects into tree structures
  - Individual object treated as a Composite
  - Same operations applied on individual and composites
  - Examples: java.awt.Component and RESTfull service GETs
 * Design
  - Tree structured
  - Component
  - Leaf or Composite, same operations
  - Composite knows about child objects
  - Component, Leaf, Composite
 * Pitfalls
  - Can overly simplify system
  - Difficult to restrict
  - Implementation can possibly be costly
 * Contrast: Composite
  - Tree structure
  - Leaf and Composite have same interface
  - Unity between objects
 * Contrast: Decorator
  - Contains another entity
  - Modifies behaviour
  - Doesn't change underlying object

Decorator Pattern
-----------------
 * Concepts
  - Also called a wrapper
  - Add behavior without affecting others
  - More than just inheritance
  - Single Responsibility Principle
  - Compose behavior dynamically
 * Design
  - Inheritance based
  - Utilizes composition and inheritance
  - Alternative to subclassing
  - Constructor requires instance from hierarchy
  - Component, ConcreteComponent, Decorator, ConcreteDecorator
  - Examples: java.io.InputStream  
 * Pitfalls
  - New class for every feature added
  - Multiple little objects
  - Often confused with simple inheritance

Facade Pattern
--------------
 * Concepts
  - Make an API easier to use
  - Reduce dependencies on outside code
  - Simplify the interface or client usage
  - Usually a refactoring pattern
  - Examples: java.net.URL
 * Design
  - Class that utilizes composition
  - Shouldn't have a need for inheritance
  - Typically encompasses full lifecycle
 * Pitfalls 
  - Typically used to clean up code
  - Should think about API design
  - Flat problem/structure
  - The "Singleton" of Structural Pattern
 * Contrast: Facade
  - Simplifies Interface
  - Works with composites
  - Cleaner API
 * Contrast: Adapter
  - Also a refactoring pattern
  - Modifies behavior
  - Provides a different interface

Flyweight Pattern
-----------------
 * Concepts
  - More efficient use of memory
  - Larage number of similar objects
  - Great with Immutable objects
  - Examples: java.lang.String, Caching, Primitive wrappers
 * Design
  - Pattern of patterns
  - Utilizes a Factory
  - Encompasses Creation and Structure
  - Client, Factory, Flyweight, ConcreteFlyweight
 * Pitfalls
  - Complex pattern
  - Premature optimization
  - Must understande Factory
  - Not a graphical pattern
 * Contrast: Flyweight
  - Memory Optimization
  - Optimization Pattern
  - Immutable Objects
 * Contrast: Facade
  - Refactoring Pattern
  - Simplified Client
  - Provides a different interface 

Proxy Pattern
-------------
 * Concepts
  - Interface by wrapping
  - Can add functionality
  - Security, Simplicity, Remote, Cost
  - Proxy called to access real object
  - Examples: java.lang.reflect.Proxy
 * Design
  - Interfaced based
  - Interface and Implementation Class
  - Client, Interface, InvocationHandler, Proxy, Implementation
 * Pitfalls
  - Only on proxy
  - Another Abstraction
  - Similar to other patterns
 * Contrast: Proxy
  - Can add functionality, but not its main purpose
  - Can only have one
  - Compile time
 * Contrast: Decorator
  - Dynamically add functionality
  - Chained
  - Decorator points to its own type
  - Runtime