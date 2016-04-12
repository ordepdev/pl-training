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
  - Object per command
  - Command Interface
  - Execute Method
  - "Unexecute" method
  - Reflection
  - Command, Invoker, ConcreteCommand
 * Pitfalls
  - Dependence on other patterns
  - Multiple Commands
  - Make use of Memento
  - Prototype for copies
 * Contrast: Command
  - Object per command
  - Class contains the "waht"
  - Encapsulates action
 * Contrast: Strategy
  - Object per strategy
  - Class contains the "how"
  - Encapsulates algorithm

Interpreter Pattern
-------------------
 * Concepts
  - Represent grammar
  - Interpret a sentence
  - Map a domain
  - Abstract Syntax Tree
  - Examples: java.util.Pattern
 * Design
  - AbstractExpression
  - Interpret
  - TerminalExpression
  - NonterminalExpression
  - Context, AbstractExpression, TerminalExpression, NonterminalExpression, Client
 * Pitfalls
  - Complexity
  - Class per rule
  - Use of other patterns
  - Adding new variant
  - Specific case
 * Contrast: Interpreter
  - Access to properties
  - Function as methods
  - Adding new functionality changes every variant
 * Contrast: Visitor
  - Needs Observer functionality
  - Functionality found in one place
  - Adding new variant requires changing every visitor

Iterator Pattern
----------------
 * Concepts
  - Traverse a container
  - Doesn't expose underlying structure
  - Decouples algorithms
  - Sequential
  - Examples: java.util.Iterator, java.util.Enumeration
 * Design
  - Interface based
  - Factory Method based
  - Independent, but fail fast
  - Enumerators are fail safe
  - Iterator, ConcreteIterator
 * Pitfalls
  - No access to index
  - Unidirectional
  - Slow in some cases
 * Contrast: Iterator
  - Interfaced based
  - Algorithm is removed
  - No index
  - Concurrent modification
 * Contrast: For loop
  - Traversal in client
  - Exposes an index
  - Doesn't change underlying object
  - foreach syntax
  - Typically slower

Mediator Pattern
----------------
 * Concepts
  - Loose coupling
  - Well-defined, but complex objects
  - Reusable components
  - Hub/Router
  - Examples: java.util.Timer
 * Design
  - Interface based
  - Concrete class
  - Minimizes inheritance
  - Mediator knows about colleagues
  - Mediator, ConcreteMediator
 * Pitfalls
  - Deity object
  - Limits subclassing
  - Over or with Command
 * Contrast: Mediator
  - Defines Interaction
  - Object decoupling
  - More specific
 * Contrast: Observer
  - One-to-Many broadcast
  - Object decoupling
  - More generic

Memento Pattern
---------------
 * Concepts
  - Restore Object to previous state
  - Externalize internal state
  - Undo/Rollback
  - Shields complext internals
  - Examples: java.util.Date
 * Design
  - Class based
  - Originator: the object that knows how to save itself
  - Caretaker: the object that knows why and when the Originator needs to save/restore
  - Memento: the object that Originator uses for read and write 