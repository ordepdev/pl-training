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

