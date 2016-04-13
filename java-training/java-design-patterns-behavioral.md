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
 * Pitfalls
  - Can be expensive
  - Delets/history
  - Exposing information
 * Contrast: Memento
  - State captured
  - Independent state
  - Caretaker/History
 * Contrast: Command
  - Request captured
  - Independent request
  - History side benefit

Observer Pattern
----------------
 * Concepts
  - One to Many
  - Decoupled
  - Event Handling
  - Pub/Sub
  - MVC
  - Examples: java.util.Observer, EventListener
 * Design
  - Subject
  - Observer
  - Observable
  - Views are Observers
  - Subject, ConcreteSubject, Observer, ConcreteObserver
 * Pitfalls
  - Unexpected updates
  - Large sized consequences
  - What changed?
  - Debugging difficult
 * Contrast: Observer
  - One-to-Many
  - Decoupled
  - Broadcast communication
 * Contrast: Mediator
  - One-to-one-to-Many
  - Decoupled
  - Complex communication

State Pattern
-------------
 * Contepts
  - Localize state behavior
  - State Object
  - Separates What from Where
  - Open Close Principle
 * Design
  - Abstract Class / Interface
  - Class based
  - Context unaware
  - Context, State, ConcreteState
 * Pitfalls
  - Know your States
  - More classes
  - Keep logic out of Context
  - State change triggers
 * Contrast: State
  - Interface based
  - Transitions
  - Class per State
 * Contrast: Strategy
  - Interface based
  - Algorithms are independent
  - Class per algorithm

Strategy Pattern
----------------
 * Concepts
  - Eliminate conditional statements
  - Behavior encapsulated in classes
  - Difficult to add new strategies
  - Client aware of strategies
  - Client chooses strategy
  - Examples: hava.util.Comparator 
 * Design
  - Abstract base class
  - Concrete class per strategy
  - Removes if/else conditionals
  - Strategies are independent
  - Context, Strategy, ConcreteStrategy
 * Pitfalls
  - Client aware of Strategies
  - Increased number of classes
 * Contrast: Strategy
  - Interface based
  - Algorithms are independent
  - Class per Algorithm
 * Contrast: State
  - Interface based
  - Transitions
  - Class per State

Template Pattern
----------------
 * Concepts
  - Code reuse
  - Common in libraries/frameworks
  - IoC
  - Algorithm emphasis
  - Examples: java.util.Collections#sort()
 * Design
  - Abstract Base class
  - Base calls Child
  - Hooks
  - Operations
  - AbstractBase, ConcreteClass
 * Pitfalls
  - Restrict access
  - Confusing hierarchy
  - Difficult Program flow
 * Contrast: Template
  - Same algorithm
  - Class based
  - Compile time
 * Contrast: Strategy
  - Algorithm per Strategy
  - Interface based
  - Runtime

Visitor
-------
 * Concepts
  - Separate Algorithm from Object
  - Adding new features
  - Maintain Open/Closed principle
  - Visitor changes
 * Design
  - Interface based
  - Visitor and Element
  - Elements have visit method
  - Visitor knows every Element
  - Visitor, ConcreteVisitor, Element, ConcreteElement 
 * Pitfalls
  - Plan for adaptability
  - Indirection somewhat confusing
  - Adapter pattern
 * Contrast: Visitor
  - Interfaced based
  - Externalized changes
  - Multiple visitors
 * Contrast: Iterator
  - Interfaced based
  - Encapsulates
  - Singular