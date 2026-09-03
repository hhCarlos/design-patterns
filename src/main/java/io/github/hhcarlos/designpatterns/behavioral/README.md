# Behavioral Patterns

## Intent

Behavioral patterns define how objects communicate, collaborate, and distribute responsibilities.
They organize algorithms, control flow, state transitions, requests, and reactions between objects.
Most object-scoped behavioral patterns prefer composition and delegation, while class-scoped patterns use inheritance
to specialize parts of an algorithm.

## Class and Object Scope
Class Scope:
Class-scoped behavioral patterns distribute behavior through inheritance. 
A base class defines the general contract or algorithm, 
while subclasses implement or override specific steps.

The relationship between the classes is established when they are defined, 
making this approach less flexible at runtime. 
However, it is useful when multiple classes must follow the same process while customizing selected parts.

In the GoF classification, the main class-scoped behavioral patterns are:

- Template Method
- Interpreter

Object Scope:
Object-scoped behavioral patterns distribute behavior through composition and delegation. 
Instead of inheriting the complete behavior, an object collaborates with other objects and delegates 
specific responsibilities to them.

Collaborators can often be replaced at runtime as long as they provide the expected behavior. 
This makes object-scoped patterns more flexible and reduces coupling between the object 
requesting an operation and the object performing it.

Most behavioral patterns are object-scoped, including Strategy, State, Observer, Command, Iterator, 
Mediator, Memento, Visitor, and Chain of Responsibility.

## Common Design Problems

Behavioral patterns address problems related to how objects communicate, distribute responsibilities, 
and change their behavior.

Common problems include:
- Supporting multiple interchangeable algorithms for the same operation.
- Changing an object's behavior according to its current internal state.
- Notifying multiple interested objects when an event or state change occurs.
- Passing a request through multiple possible handlers without coupling the sender to a specific receiver.
- Representing an operation as an object so it can be stored, queued, logged, or undone.
- Traversing a collection without exposing its internal representation.
- Coordinating multiple objects without requiring them to reference each other directly.
- Capturing and restoring an object's previous state.
- Defining the fixed sequence of an algorithm while allowing subclasses to customize individual steps.
- Adding new operations to an existing object structure without repeatedly modifying its classes.
- Representing and interpreting the rules of a small language or grammar.

These problems usually appear when conditionals, dependencies, or communication between objects begin to spread 
throughout the system.

## Relationship with SOLID

Behavioral patterns often support SOLID principles by separating responsibilities and allowing objects to collaborate 
through stable contracts. However, using a pattern does not automatically make a design SOLID; 
the implementation must still preserve clear responsibilities and valid abstractions.

| Principle                       | Relationship with Behavioral Patterns                                                                                                                  |
| ------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------ |
| Single Responsibility Principle | Behaviors such as validation, notification, state management, or algorithm selection can be moved into separate objects with focused responsibilities. |
| Open/Closed Principle           | New strategies, states, commands, handlers, or observers can often be added without modifying the object that uses them.                               |
| Liskov Substitution Principle   | Interchangeable behavioral objects must respect the same contract and preserve the expectations of the client using them.                              |
| Interface Segregation Principle | Small and focused behavioral contracts prevent objects from depending on operations they do not need.                                                  |
| Dependency Inversion Principle  | High-level objects can depend on behavioral abstractions or capabilities instead of concrete implementations.                                          |

For example, a checkout service can depend on any object capable of processing a payment rather than depending directly on a specific payment provider. New payment strategies can then be introduced without changing the checkout workflow.

## Included Patterns

| Pattern | Purpose |
|---|---|
| Chain of Responsibility | Passes a request through a sequence of handlers until one of them processes it. |
| Command | Encapsulates an action or request as an object, allowing it to be stored, queued, logged, or undone. |
| Interpreter | Represents and evaluates the grammar or rules of a small language. |
| Iterator | Provides sequential access to a collection without exposing its internal structure. |
| Mediator | Centralizes and coordinates communication between multiple objects. |
| Memento | Captures and restores an object's previous state without exposing its internal implementation. |
| Observer | Notifies multiple subscribers when a publisher changes or produces an event. |
| State | Changes an object's behavior according to its current internal state. |
| Strategy | Encapsulates interchangeable algorithms and allows the client to select the appropriate one. |
| Template Method | Defines the fixed structure of an algorithm while allowing subclasses to customize specific steps. |
| Visitor | Adds operations to an existing object structure without modifying every element class. |

## When This Family Is Useful

Behavioral patterns are useful when the main design problem involves how objects communicate, 
distribute responsibilities, or change their behavior.

Consider using this family when:

- Multiple algorithms can perform the same operation and must be interchangeable.
- An object's behavior changes according to its current state.
- Large conditional blocks repeatedly select behavior.
- A sender should not depend directly on the object that handles its request.
- Multiple objects must react to the same event or state change.
- Operations need to be stored, queued, logged, retried, or undone.
- A collection must be traversed without exposing its internal representation.
- Communication between multiple objects has become difficult to coordinate.
- An object's previous state must be captured and restored.
- A process has a stable sequence but some steps require customization.
- New operations must be added to a stable structure of different object types.

Behavioral patterns are especially valuable when behavior is expected to evolve independently from the objects using it.

## Common Misuses

Behavioral patterns can introduce unnecessary complexity when they are applied without a clear behavioral problem.

Common misuses include:

- Applying a pattern before the behavior actually varies.
- Replacing simple functions or conditional logic with unnecessary class hierarchies.
- Creating too many small classes, making the execution flow difficult to follow.
- Hiding important dependencies behind excessive delegation.
- Using inheritance when composition would provide safer and more flexible behavior.
- Confusing Strategy with State: a strategy is usually selected to perform an operation, while state changes as part of an object's lifecycle.
- Allowing interchangeable objects to violate the contract expected by their clients.
- Creating Observer relationships without controlling subscription, notification order, or cleanup.
- Building a Mediator that becomes a central object with too many responsibilities.
- Allowing a Chain of Responsibility to silently ignore requests when no handler processes them.
- Storing large numbers of Mementos without considering memory usage.
- Using Visitor when the object structure changes frequently, making every visitor difficult to maintain.
- Applying Template Method when subclasses need to change most of the original algorithm.

A behavioral pattern should clarify how responsibilities are distributed. 
If it adds more indirection than understanding, the simpler design is usually preferable.
