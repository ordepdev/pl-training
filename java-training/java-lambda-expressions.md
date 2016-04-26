Java - Lambda Expressions
=========================

Functional Interface
--------------------
 * A function interface is an interface:
  - With only one abstract method
  - Default methods do not count
  - Static methods do not count
  - Methods from the Object class do not count
 * A functional interface may be annotated with @FunctionalInterface
  - It is not mandatory, for legacy reasons
  - The compiler will tell us if an annotated interface is functional or not
 * A functional interface have four categories:
  - Consumers
  - Suppliers
  - Functions
  - Predicates

Stream: Definitions
-------------------
 * A Stream does not hold any data
  - it pulls the data it processes from a source
 * A Stream does not modify the data it processes
  - Because we want to process the data in parallel with no visibility issues
 * The source may be unbounded
  - Which can mean it is not finite
  - But most of the time, it only means that the size of this source is not known at build time
 * Many patterns to build Streams:
   - Stream.empty()
  - Stream.of()

Stream Calls: Terminal vs Intermediate
--------------------------------------
 * Terminal
  - a terminal operation must be called to trigger the
process of a Stream (lazy)
  - a terminal operation returns void or anything unless a Stream
 * Intermediate
  - does not process data
  - always returns a Stream	

Stream simple reductions: Match Reduction
-----------------------------------------
 * Three types of matchers: anyMatch(), allMatch() and noneMatch()
 * These matchers are terminal operations that return a boolean
 * These matchers may not evaluate the predicate for all the elements
 * They are called short-circuiting terminal operations

Stream simple reductions: Find Reduction
----------------------------------------
 * There are two types of find reduction: findFirst() and findAny()
 * They might have nothing to return:
  - if the stream is empty
  - or if there is no value that matches the predicate
 * They both return an Optional, that can be empty

Stream simple reductions: Reduce Reduction
------------------------------------------
 * There are three types of reduce reduction 
 * If no identity element is provided, then an Optional is returned
 * Associativity is assumed fot the reduction function, but not enforced

