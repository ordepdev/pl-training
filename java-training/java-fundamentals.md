Java Fundamentals
=================

Variables, Data Types, and Math Operators
-----------------------------------------
 * Variables are strongly typed
 * Primitive types
  - Integer, floating points, char, boolean
 * Math Operators
  - Basic, postfix/prefix, compound assignment
 * Type conversions
  - Compiler can automatically apply widening type conversions
  - Use type casting to explicity perform type conversions

Classes Initializers and Constructors
-------------------------------------
 * Objects sould be created in some useful state
 * Field initializers provide an initial value as part of the declaration
 * Every class has at least one constructor
  - If no explicit constructor, Java provides one
 * One constructor can call another
 * Initialization blocks share code across constructors
 * Keep the initialization and construction order in mind

Parameters
----------------------
 * Paramenters are passed by making a copy of the value
 * Changes made to passed value **are not visible** outside of method
 * Changes made to members of passed class instances **are visible** outside of method
 * Parameters are immutable
 * A method can be declared to accept varying number of parameter values
   - this values are received as an array and must be the last parameter

Class Inheritance
-----------------
 * Inheritance allows a new class to be defined with the characteristics of another
  - using the extends keyword
 * Derived class can override base class methods
  - using @Override annotation
 * All classes derive from Object
 * By default, object references are only equal when referencing the same instance
 * super accesses current object as if instance of base class
 * final and abstract provide control over class inheritance and method overriding
 * Constructors are **not** inherited

More about Data Types
---------------------
 * String class stores an immutable sequence of Unicode characters
  - toString() method provide conversion to a string
 * StringBuilder class provides an efficient way to manipulate string values
 * Primitive wrapper classes bring class capabilities to primitive values
  - wrapper classes much less efficient then primitive types
 * Final fields prevent a value from being changed once assigned
  - simple final fields must be set during object instance creation
  - static final fields act as named constants

Exceptions
----------
 * Exceptions provide a non-intrusive way to signal errors
 * Exceptions are caught by type
  - can have separate catch statement for diferent exception types
  - catch from most specific type to least
 * Raise exceptions using throw
 * Methods must declare any unhandled checked exceptions using throws
 * Can create custom exception types that derive from Exception

Packages
--------
 * A package is a group of related types
 * Type name qualified by package name
 * Packages serve as an access boundary
 * Packages simplify distribution
  - types organized hierarchically according to the package name
  - archive files store package hierarchy in a single file

Interfaces
----------
 * Defines a contract
  - provides no implementation
   - can include methods and constants
 * Classes can implement multiple interfaces
 * Interfaces are able to extend other interfaces

Static Methods, Nested Types and Anonymous Classes
--------------------------------------------------
 * Static methods and fields are shared class-wide
 * Static initialization blocks provide one-time type initialization
 * A nested type is a type declared within another type
  - it can be used to provide structure and scoping
  - inner classes create an association between nested and enclosing instances
 * Anonymous classes are declared as part of their creation
  - useful for simple interface implementations and class extensions

===========================
Java Fundamentals: Generics
===========================

Why Generics?
-------------
 * Generics stop runtime errors at compile time
 * Provides type safety

Generic Collections
-------------------
 * List<Person> x = new ArrayList<>();
  - an ordered collection
 * Set<Person> x = new HashSet<>();
  - unique elements collection
 * Map<String, Person> x = new HashMap<>();
  - a dictionary that maps a single value to each unique key

Interfaces
----------
 * Multiple Data Structures
 * Functional Characteristics
 * Prefer as variable type
 * Often has a popular implementation

Implementation
--------------
* Specific Data Structure
* Performance Characteristics
* Concrete and Instantiable

Generic Classes and Interfaces
------------------------------
 * Implementing a generic type
  - AgeComparator implements Comparator<Person>
 * Passing a parameter to a generic type
  - Reverser<T> implements Comparator<T>
 * Type Bounds
  - SortedPair<T extends Comparable<T>>

Wildcards
---------
 * Upper Bounded
  - List<? extends Cls>
  - Declare an upper bound for the type parameter
  - To get data out of the parameter
  - Covariance
 * Lower Bounded
  - List<? super Cls>
  - Declare a lower bound for the type parameter
  - To put data into the parameter
  - Contravariance
 * Unbounded
  - List<?>

Erasure
-------
 * Generic Type Parameters are erased at compile time
  - List<String> -> List
  - List<String>[] -> List[]
  - T without bounds -> Object
  - T extends Foo -> Foo
 * Under the hood, Generics uses Casts.

Reflection
----------
 * Reflected Types
  - Primitives: int, long
  - Non Parameterized Class or Interface: String, ActionListener
  - All type arguents are unbounded Wildcards: List<?>, Map<?, ?>
  - Raw Types: List, Map
  - Arrays of reifiable components: int[][], List<?>[]
 * Non Reflected Types
  - Type Variables: T
  - Parameterized Type with Parameters: ArrayList<String>, Map<Integer, String>
  - Parameterized Type with Bounds: List<? extends Number>, Consumer<? super String>

Generics Recap
--------------
 * Generics let us add type parameters to classes
 * The most common users of this feature are Java Collections
 * In Java we often implement interfaces or extend classes
 * Wildcards make type parameters more flexible
 * You can't reflect all generic information, because it gets erased at compile time
 * Rawtypes let us represent a type without a parameter
 * Lambdas have their types infered
 * Intersection types are powerful <T extends A & B>

====================
What's new in Java 8
====================
Lambda Expressions
------------------
  * What for?
   - to make instances of anonymous classes easier to write and read
  * How to write?
   - inline, or inside {} if more than one line of code
  * What is the type of a lambda expression?
   - Is a functional interface. Is an interface with only one abstract method
  * Can a lambda be in a variable?
   - a lambda can be taken as method parameter, and can be returned by a method
  * Is a lambda expression an object?
   - a lambda is a more complex object, is an object without its own identity
  * Most of the sime, parameter types can be omitted
   - (String s1, String s2) -> ... becomes: (s1, s2) -> ...
  * Lambdas can be even simplier with method references
   - list.forEach(customer -> System.out.println(customer)) to
   - list.forEach(System.out::println) 
  * Default Methods, allows to change the old interfaces without breaking the existing implementations

Streams and Collectors
----------------------
 * Map, Filter, Reduce
 * What is a Stream?
  - a stream, is a typed interface: Stream<T>
  - is an object on which one can define operations
  - is an object that does not hold any data
  - is an object that should not change the data it processes
  - is an object able to process data in "one pass"
  - it gives ways to efficiently process large amout of data, and smaller ones
  - efficiently? yes.
    - in parallel, to leverage the computing power of multicore CPUs
    - pipelined, to avoid unnecessary intermediary computations
 * All the methods of Stream that return another Stream are lazy, also called as intermediary operation
  - peek, filter, map, flatMap
 * Only the final operations, methods that not return Stream, will trigger the processing of the data
  - forEach
 * Reductions
  - boolean: allMatch(), noneMatch(), anyMatch()
  - optional: findFirst(), findAny(), max(), min()
  - reductions are terminal operations, as they trigger the processing of the data
 * A stream cannot be reused

Date and Time
-------------
 * ~ Java 7 ~
 * Date is mutable
 * Defensive copy:
  - public Date getCreationDate() {
    return new Date(this.creationDate.getTime());
  }
  - creates an overhead for the GC: a new object is created on each call
  - having a mutable Date class has a cost
 * ~ Java 8 ~
 * Instant: is a point on the time line
  - Instant 0 is the January the 1st, 1970 at midnightGMT
  - Instant.MIN is 1 billion years agora
  - Instant.MAX is Dec.31 of the year 1.000.000.000
  - Instant.now() is the current instant
  - IS IMMUTABLE!
  - How to use?
  -   Instant start = Instant.now();
      ...
      Instant end = Instant.now();
      Duration elapsed = Duration.between(start, end);
      long millis = elapsed.toMillis();
 * Duration: is the amout of time between two Instant
 * LocalDate:
  - LocalDate now = LocalDate.now();
  - LocalDate dateOfBirth = LocalDate.of(1991, Month.NOVEMBER, 29);
 * Period: is the amount of time between two LocalDate
  - dateOfBirth.until(now).getYears(); // => 24
  - dateOfBirth.until(now, ChronoUnit.DAYS); // => to many :(
 * DateAdjuster: useful to add an amount of time to an Instant or LocalDate
  - LocalDate nextSunday = LocalDate.now().with(TemporalAdjuster.next(DayOfWeek.SUNDAY));
 * LocalTime: is a time of day ~ 10:20
  - LocalTime.now() / LocalTime.of(10, 20); / time.plusHours(8)
 * Zoned Time: how to handle all time zones over the earth
  - Set<String> allZonesIds = ZoneId.getAvailableZoneIds();
  - String ukTZ = ZoneId.of("Europe/London");
  - ZonedDateTime meetingLondon = ZonedDateTime.of(
      LocalDate.of(2016, Month.APRIL, 6),
      LocalTime.of(12, 00),
      ZoneId.of("Europe/London")
  ).plus(Period.ofMonth(1));
  - meetingLondon.withZoneSameInstant(ZoneId.of("US/Central"));

Strings and IO
--------------
 * Stream was introduced on a String:
  - String value = "Hello world!";
  - value.chars().map(String::toUpperCase).forEach(System.out::print);
 * Concatenation of Strings using the + operator: "it's not efficient", "multiple creations/deletions"
 * StringBuffer, better than + but is synchronized
 * StringBuilder, better than StringBuffer, not synchronized, but... is not called in a multi-threaded env
 * StringJoiner, the best solution: sj = new StringJoiner(", ").add("one").add("two").toString(); or using the String.join()