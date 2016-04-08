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
