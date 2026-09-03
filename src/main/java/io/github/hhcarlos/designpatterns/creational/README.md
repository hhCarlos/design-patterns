# Creational Patterns

## Intent

Creational patterns separate object construction from object usage.
Class-scoped patterns use inheritance to let subclasses choose what is instantiated,
while object-scoped patterns use composition and delegation to assign construction to collaborating objects.
This separation supports controlled assembly and allows clients to work with new concrete implementations without
changing their main workflow.

## Class and Object Scope

Class Scope:
Class-scoped creational patterns use inheritance to let subclasses determine which concrete objects are created. 
A base class defines the general creation operation and workflow, while subclasses override a factory method 
to produce the required implementation.

The creation decision is therefore connected to the class hierarchy and is usually established when the subclass 
is defined.

In the GoF classification, Factory Method is the main class-scoped creational pattern.

Object Scope:
Object-scoped creational patterns use composition and delegation to assign object construction to a separate object.
A client can receive a factory, builder, prototype, or shared instance responsible for providing the required objects.

Because construction is delegated to collaborators, the creation mechanism can often be configured or replaced without 
modifying the client or creating another subclass.

In the GoF classification, the object-scoped creational patterns are:
- Abstract Factory
- Builder
- Prototype
- Singleton

## Common Design Problems

Creational patterns address problems caused by coupling object construction directly to the code that uses the 
resulting objects.

Common design problems include:
- Clients depending directly on concrete classes and constructors.
- Creation logic being duplicated across multiple parts of the application.
- Selecting different concrete implementations according to configuration, environment, or runtime conditions.
- Creating families of related objects that must remain compatible with each other.
- Constructing complex objects that require multiple ordered steps or optional configurations.
- Preventing objects from existing in incomplete or invalid states during construction.
- Creating multiple representations from the same construction process.
- Creating new objects by copying an existing configured instance.
- Avoiding repeated expensive initialization when similar objects are required.
- Controlling how many instances of a class can exist.
- Providing controlled access to a shared instance or resource.
- Testing clients without constructing their real production dependencies.

These problems typically indicate that object creation has become a separate responsibility and should no longer 
remain inside the code that consumes the object.


## Relationship with SOLID

## Included Patterns

## When This Family Is Useful

Creational patterns are useful when object construction varies, requires coordination, or should evolve independently 
from the code using the created objects.

Consider using this family when:
- Clients should work without knowing the concrete classes being instantiated.
- Different implementations must be selected according to configuration, environment, or runtime conditions.
- Object creation logic is duplicated across multiple parts of the application.
- A complex object requires multiple construction steps, optional components, or validation rules.
- Related objects must be created as compatible families.
- Subclasses need to determine which concrete objects are created.
- Creating an object is expensive and copying an existing configured instance is more efficient.
- The number of instances must be controlled.
- A shared resource requires a controlled access point.
- Objects must always be created in a complete and valid state.
- Production dependencies need to be replaced with test doubles during automated testing.

A direct constructor call is usually sufficient when creation is simple, stable, and only requires a few clear arguments. 
Creational patterns become valuable when construction itself develops variations, rules, dependencies, 
or a separate reason to change.

## Common Misuses

Creational patterns can introduce unnecessary abstraction and indirection when object construction is 
still simple or unlikely to vary.

Common misuses include:
- Creating a factory that only wraps a single simple constructor without adding selection, validation, or configuration logic.
- Introducing factories, builders, and abstractions only for hypothetical future requirements.
- Creating a large central factory containing conditionals for every object in the application.
- Using Builder for objects that only require a few clear constructor arguments.
- Hiding required dependencies inside factories or service locators instead of declaring them explicitly.
- Allowing a factory to return incompatible objects that do not respect the behavior expected by the client.
- Requiring clients to understand internal construction details even after introducing a creational abstraction.
- Using Singleton as a convenient replacement for global variables.
- Storing mutable global state inside a Singleton, causing hidden dependencies, test interference, or concurrency problems.
- Cloning objects through Prototype without considering shared mutable references or shallow-copy behavior.
- Using Abstract Factory when the created objects do not actually form related or compatible families.
- Allowing Builder to produce incomplete or invalid objects.
- Adding so many construction layers that it becomes difficult to identify where an object is actually created and configured.
- Ignoring ownership, lifecycle, and cleanup responsibilities for created resources.

A creational pattern should simplify construction or isolate meaningful variation. 
If it only hides a direct constructor behind additional classes and methods, it is probably unnecessary.
