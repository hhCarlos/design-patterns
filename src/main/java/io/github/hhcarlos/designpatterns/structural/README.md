# Structural Patterns

## Intent

Structural patterns define how classes and objects are connected to form flexible structures. 
Rather than relying exclusively on inheritance, many structural patterns use composition and delegation to adapt interfaces, 
organize object hierarchies, simplify complex subsystems, control access, or add responsibilities without modifying existing 
components.

## Class and Object Scope

Class Scope:

Class-scoped structural patterns use inheritance to connect interfaces or implementations. A subclass adapts or extends
behavior by inheriting from an existing class and exposing the contract expected by its clients.

Because the relationship is defined through the class hierarchy, it is generally fixed when the classes are declared
and cannot be replaced independently at runtime. This approach can be useful when the inherited behavior is stable,
but it also creates stronger coupling between the participating classes.

In the GoF classification, Class Adapter is the main class-scoped structural pattern. It adapts an existing class
through inheritance so that it can satisfy another interface. This implementation may require multiple inheritance or
a language-specific combination of class inheritance and interface implementation.

Object Scope:

Object-scoped structural patterns use composition and delegation to connect collaborating objects. Instead of
inheriting behavior directly, an object stores references to other objects and forwards responsibilities to them.

These relationships can usually be configured, replaced, combined, or nested at runtime. This provides greater
flexibility and avoids creating large inheritance hierarchies for every possible structural variation.

In the GoF classification, the object-scoped structural patterns are:

- Object Adapter
- Bridge
- Composite
- Decorator
- Facade
- Flyweight
- Proxy

Adapter appears in both scopes because it has two implementations:
Class Adapter uses inheritance, while Object Adapter wraps an existing instance and delegates operations to it.

## Common Design Problems

Structural patterns address problems caused by rigid relationships between classes, incompatible interfaces, complex
object hierarchies, and clients that depend too heavily on implementation details.

Common design problems include:

* Integrating an existing, legacy, or third-party class whose interface does not match the interface expected by the
  client.

* Allowing an abstraction and its implementation to evolve independently without creating a subclass for every
  possible combination.

* Representing part-whole hierarchies in which clients should treat individual objects and groups of objects
  uniformly.

* Adding responsibilities such as logging, validation, caching, formatting, or authorization without modifying the
  original class.

* Combining multiple optional behaviors without creating an excessive number of subclasses.

* Providing a simple entry point to a large or complicated subsystem.

* Preventing clients from depending directly on multiple internal subsystem components.

* Controlling access to another object for security, lazy initialization, caching, remote communication, or resource
  management.

* Representing an expensive object only when it is actually required.

* Sharing common immutable state between many fine-grained objects to reduce memory consumption.

* Wrapping an object while preserving the interface expected by its existing clients.

* Replacing a real object with a stand-in that can perform additional work before or after forwarding a request.

* Building recursive structures such as folders, menus, organizational trees, or graphical component hierarchies.

* Avoiding inheritance hierarchies that grow rapidly as new combinations of features are introduced.

* Isolating clients from structural changes made inside a subsystem or implementation.

These problems usually indicate that the relationships between components require their own design. Structural
patterns provide controlled ways to connect, wrap, organize, share, or substitute objects without forcing clients to
manage those structural details directly.

## Relationship with SOLID

Structural patterns often support SOLID by connecting components through stable abstractions and favoring composition
and delegation over rigid inheritance. They allow interfaces, implementations, responsibilities, and access mechanisms
to evolve with less impact on client code.

However, wrapping or composing objects does not automatically produce a SOLID design. Each participant must retain a
clear responsibility and every substitute or wrapper must preserve the contract expected by its clients.

* Single Responsibility Principle (SRP):
  Adapter isolates interface conversion, Proxy isolates access control, Facade coordinates subsystem access, and
  Decorator separates optional responsibilities into focused components. These patterns support SRP when each
  structural object has one clear reason to change. The principle is violated when a Facade becomes a god object or a
  wrapper accumulates unrelated behaviors.

* Open/Closed Principle (OCP):
  Decorators can add behavior, Adapters can integrate new implementations, and Proxies can introduce access policies
  without modifying existing components. Bridge allows new abstractions and implementations to be added independently.
  Structural patterns support extension when clients continue working through stable contracts rather than concrete
  types.

* Liskov Substitution Principle (LSP):
  Decorators, Proxies, Adapters, and Composite participants must behave according to the interfaces they expose.
  A wrapper should be usable wherever the wrapped component is expected without introducing incompatible results,
  invalid states, or surprising restrictions. Composite leaves and containers must also honor the common operations
  promised to their clients.

* Interface Segregation Principle (ISP):
  Adapters can expose only the operations required by a particular client, while Facades can provide focused entry
  points for different uses of a subsystem. Bridge implementations and Composite components should avoid broad
  interfaces that force participants to support meaningless operations. Separate focused interfaces are preferable
  when clients require different capabilities.

* Dependency Inversion Principle (DIP):
  Clients can depend on shared component abstractions instead of concrete implementations. Bridge connects an
  abstraction to an implementation interface, while Decorator, Proxy, and Composite allow collaborators to be supplied
  through common contracts. Concrete implementations should be provided from outside the high-level client rather than
  created or discovered through hidden global access.

Structural patterns support SOLID most effectively when composition reduces coupling without hiding important behavior.
Their abstractions should clarify how components collaborate, preserve substitutability, and prevent implementation
details from spreading into high-level application logic.

## Included Patterns

The GoF structural family contains seven patterns:

* Adapter — Class and Object Scope:
  Converts the interface of an existing class into another interface expected by the client. Use it when legacy,
  third-party, or otherwise incompatible code must collaborate with an existing system without modifying either side.
  Class Adapter uses inheritance, while Object Adapter uses composition and delegation.

* Bridge — Object Scope:
  Separates an abstraction from its implementation so that both can evolve independently. Use it when a design contains
  two independent dimensions of variation and inheritance would create a subclass for every possible combination.

* Composite — Object Scope:
  Organizes objects into recursive tree structures and allows clients to treat individual objects and groups uniformly.
  Use it for part-whole hierarchies such as folders, menus, graphical components, organizational structures, or nested
  business rules.

* Decorator — Object Scope:
  Adds responsibilities to an object dynamically by wrapping it with another object that implements the same interface.
  Use it when behaviors must be combined or added independently without modifying the original class or creating a
  subclass for every possible combination.

* Facade — Object Scope:
  Provides a simplified and unified interface to a complex subsystem. Use it when clients should access a common
  workflow without understanding or depending directly on the subsystem's internal classes and interactions.

* Flyweight — Object Scope:
  Reduces memory consumption by sharing common immutable state between many fine-grained objects. Use it when an
  application creates a very large number of similar objects and a significant portion of their state can be shared.

* Proxy — Object Scope:
  Provides a substitute or representative for another object and controls access to it while preserving the expected
  interface. Use it for lazy initialization, access control, remote communication, caching, logging, or other operations
  performed before or after forwarding a request to the real object.

Several structural patterns wrap or reference another object, but their intentions are different:

- Adapter changes an incompatible interface into one the client understands.
- Bridge separates two dimensions that should evolve independently.
- Decorator preserves an interface while adding behavior.
- Facade exposes a simpler interface to an entire subsystem.
- Proxy preserves an interface while controlling access to the real object.
- Composite creates uniform relationships between individual objects and groups.
- Flyweight shares reusable state between many objects.

## When This Family Is Useful

Structural patterns are useful when the relationships between components must vary, remain replaceable, or be hidden
from the clients using the resulting structure.

Consider using this family when:

- An existing, legacy, or third-party component must work with an incompatible client interface.
- An abstraction and its implementation represent independent dimensions that should evolve separately.
- Individual objects and groups of objects must be treated through the same interface.
- Responsibilities must be added or combined dynamically without modifying the original component.
- Subclassing would create a large number of classes for every possible combination of behaviors.
- Clients need a simple entry point to a complex subsystem.
- Subsystem internals should be protected from direct client dependencies.
- Access to an object requires authorization, caching, lazy initialization, logging, remote communication, or another
  form of control.
- A resource is expensive to create and should not be initialized until it is actually needed.
- An application creates many similar fine-grained objects whose common state can be shared.
- A real implementation must be replaced transparently by a wrapper or representative.
- Recursive part-whole structures must be modeled without forcing clients to distinguish between leaves and groups.
- Existing components must be extended without changing their source code.
- Object relationships need to be configured or replaced at runtime.

Direct composition or a normal method call is usually sufficient when the relationship is simple, stable, and already
under the application's control. Structural patterns become valuable when the connection between components develops
incompatibilities, variations, access rules, recursive organization, or a separate reason to change.

## Common Misuses

Structural patterns can introduce unnecessary indirection, hidden behavior, and difficult object graphs when the
underlying relationship is still simple.

Common misuses include:

- Creating an Adapter when the original interface can be changed safely and is fully controlled by the application.
- Adding multiple Adapter layers until it becomes difficult to determine which interface is actually being used.
- Using inheritance-based adapters when composition would provide sufficient flexibility and lower coupling.
- Introducing Bridge before the abstraction and implementation have genuine independent variations.
- Creating a Composite for a structure that is not recursive or whose leaves and containers do not share meaningful
  behavior.
- Forcing leaf objects to implement operations that only make sense for composite containers.
- Requiring clients to perform concrete type checks inside a Composite, defeating uniform treatment.
- Using Decorator for behavior that should be a clear responsibility of the original component.
- Building deep Decorator chains whose execution order changes behavior in undocumented ways.
- Allowing decorators to expose operations unavailable through the shared component interface.
- Turning a Facade into a large god object containing unrelated business rules and application logic.
- Allowing clients to bypass the Facade and depend directly on subsystem internals without a deliberate reason.
- Using Flyweight when the number of objects is too small for state sharing to provide a meaningful benefit.
- Placing mutable context-specific state inside a Flyweight and unintentionally sharing it between clients.
- Using Proxy when direct access is already simple and no meaningful access control or lifecycle behavior is required.
- Hiding expensive network, database, or initialization operations behind a Proxy without making their cost and
  failure behavior clear.
- Confusing Proxy, Decorator, and Adapter because they may have similar wrapper structures despite having different
  intentions.
- Creating wrapper chains that make debugging, object identity, equality, or lifecycle management difficult.
- Breaking the original component contract by changing expected behavior inside a wrapper.
- Ignoring ownership and cleanup responsibilities when several structural objects reference the same resource.
- Applying a structural pattern only to demonstrate knowledge of the pattern rather than to solve an existing design
  problem.

A structural pattern should make collaboration between components easier to understand and modify. If the pattern
creates more layers than meaningful structural variation, access control, or compatibility requires, direct
composition is probably the clearer design.
