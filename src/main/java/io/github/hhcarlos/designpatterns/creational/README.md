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

Creational patterns often support SOLID by separating object construction from the behavior 
that uses the created objects.

They allow creation rules to change independently and help clients depend on stable contracts rather than concrete
constructors.

However, using a creational pattern does not automatically make a design SOLID. The pattern must preserve clear
responsibilities, explicit dependencies, and valid behavioral contracts.

* Single Responsibility Principle (SRP):
  A client should focus on its application behavior instead of also coordinating complex object construction.
  Factories and builders can move creation logic into components whose primary responsibility is assembling objects.
  This separation is lost when one large factory becomes responsible for constructing unrelated objects throughout
  the entire application.

* Open/Closed Principle (OCP):
  Clients can remain unchanged when new concrete implementations are introduced behind an existing product or factory
  abstraction. Factory Method can support extension through new creator subclasses, while Abstract Factory allows
  complete product families to be replaced. This benefit depends on the type of variation: adding an entirely new
  product category may still require existing factory interfaces to change.

* Liskov Substitution Principle (LSP):
  Concrete products returned by a factory must respect the behavior promised by their shared abstraction. Clients
  should be able to use any returned implementation without checking its concrete type or changing their workflow.
  Creator subclasses must also preserve the creation contract established by their base class.

* Interface Segregation Principle (ISP):
  Factory and builder interfaces should expose only the creation operations required by their clients. Clients should
  not be forced to depend on methods for unrelated products or optional construction steps they never use. Large
  abstract factories may need to be divided when different clients require independent parts of a product family.

* Dependency Inversion Principle (DIP):
  High-level application logic can depend on product and factory abstractions instead of concrete classes. Concrete
  factories, builders, or implementations can then be provided through dependency injection or configuration.
  Creational patterns violate this principle when they hide dependencies behind global access, static service
  locators, or uncontrolled Singleton state.

Creational patterns therefore support SOLID when they make construction a clear and replaceable responsibility.

They should expose dependencies rather than hide them and must always return objects that satisfy the contracts
expected by their clients.

## Included Patterns

The GoF creational family contains five patterns:

* Factory Method — Class Scope:
  Defines a creation operation in a base creator and allows subclasses to decide which concrete product is
  instantiated. Use it when object creation should vary through inheritance while the general workflow remains
  defined by the parent class.

* Abstract Factory — Object Scope:
  Provides an interface for creating families of related or compatible objects without exposing their concrete
  classes. Use it when an application must switch complete product families while preventing incompatible products
  from being combined.

* Builder — Object Scope:
  Separates the step-by-step construction of a complex object from its final representation. Use it when construction
  includes ordered steps, optional values, validation rules, or multiple representations produced through a similar
  process.

* Prototype — Object Scope:
  Creates new objects by copying an existing configured instance. Use it when initialization is expensive, when many
  similar objects are required, or when their concrete types should not be coupled to the client performing the copy.

* Singleton — Object Scope:
  Controls the creation of a class so that only one instance exists and provides a shared access point to it. Use it
  only when single-instance ownership is a genuine domain or infrastructure requirement, not merely as convenient
  global state.

The appropriate pattern depends on what varies in the construction process: subclasses select products with Factory
Method, factories provide compatible families with Abstract Factory, builders coordinate construction steps,
prototypes copy configured objects, and Singleton controls instance count.

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
