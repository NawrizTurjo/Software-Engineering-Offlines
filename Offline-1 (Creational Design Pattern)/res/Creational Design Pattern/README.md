# There are four types of creational design patterns:
# 1. Singleton Pattern
# 2. Factory Method Pattern
# 3. Abstract Factory Pattern
# 4. Builder Pattern

## Singleton Pattern
The Singleton pattern is a creational design pattern that restricts the instantiation of a class to one object. This is useful when exactly one object is needed to coordinate actions across the system. The concept is sometimes generalized to systems that operate more efficiently when only one object exists, or that restrict the instantiation to a certain number of objects. The term comes from the mathematical concept of a singleton.
(easier catch: use it when you want to have only one instance of a class)

## Factory Method Pattern
The Factory Method pattern is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created. Factory Method is a method that creates objects without specifying the exact class to create. This pattern separates the construction of a complex object from its representation, enabling the same construction process to create various representations.
(easier catch: use it when you want to create objects without specifying the exact class to create)

## Abstract Factory Pattern
The Abstract Factory pattern is a creational design pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes. The Abstract Factory pattern is also known as the Kit pattern.
(easier catch: use it when you want to create families of related or dependent objects without specifying their concrete classes)

## Builder Pattern
The Builder pattern is a creational design pattern that lets you construct complex objects step by step. The pattern allows you to produce different types and representations of an object using the same construction code.
(easier catch: use it when you want to construct complex objects step by step)
