# Assignment 2 Report

## Factory Method and Abstract Factory

**Project:** Smart Security System  
**Student:** Vilgelm Feller  
**Repository:** https://github.com/Vinchester021/assignment-2-factories

## 1. Domain

The selected domain is a smart security ecosystem for buildings.

The system contains three product types:

1. Access controller
2. Security sensor
3. Alert service

The original product families are:

- Apartment
- Villa
- Office

The fourth family added later is:

- Warehouse

## 2. Initial Version Without Factories

The first version created all concrete objects directly inside `Main`.

For example, the application created `ApartmentAccessController`, `ApartmentSecuritySensor` and `ApartmentAlertService` using `new`.

A large `if/else` structure selected the required building family.

### Design Problems

The initial implementation had the following problems:

1. **High coupling:** `Main` depended on all nine concrete product classes.
2. **Duplicated code:** the same security operations were repeated for every family.
3. **Difficult extension:** adding a new family required another large branch in `Main`.
4. **Mixed responsibilities:** object creation and business logic were in the same class.
5. **Compatibility risk:** products from different families could be combined manually.

This version is available in the first Git commit.

## 3. Factory Method

The Factory Method pattern is used to create security events.

### Product

The product interface is `SecurityEvent`.

It defines:

- event type;
- event description;
- event priority.

### Concrete Products

- `IntrusionEvent`
- `FireEvent`
- `VacationEvent`

### Creator

`SecurityEventCreator` is the abstract Creator.

The method:

```java
public abstract SecurityEvent createEvent();
```

is the Factory Method.

### Concrete Creators

- `IntrusionEventCreator`
- `FireEventCreator`
- `VacationEventCreator`

The Creator contains meaningful business logic. The `processEvent()` method:

1. validates the security system;
2. creates an event;
3. determines the priority name;
4. creates a formatted event report;
5. executes the required security response.

Therefore, the Creator does more than only return a new object.

## 4. Abstract Factory

The Abstract Factory interface is `SecuritySystemFactory`.

It creates:

```java
AccessController createAccessController();
SecuritySensor createSecuritySensor();
AlertService createAlertService();
```

### Concrete Factories

- `ApartmentSecurityFactory`
- `VillaSecurityFactory`
- `OfficeSecurityFactory`
- `WarehouseSecurityFactory`

Each factory creates a complete product family.

For example, `VillaSecurityFactory` creates:

- `VillaAccessController`;
- `VillaSecuritySensor`;
- `VillaAlertService`.

## 5. Product Compatibility

Compatibility is provided by the architecture.

The `SecuritySystem` constructor receives one `SecuritySystemFactory`. It does not receive three separate concrete products.

The client asks the same factory to create all three products. Therefore, the client always receives one compatible family.

Business logic depends only on:

- `AccessController`;
- `SecuritySensor`;
- `AlertService`;
- `SecuritySystemFactory`.

It does not depend on concrete product implementations.

## 6. Runtime Factory Selection

The factory is selected from a command-line argument.

Supported values:

- `apartment`
- `villa`
- `office`
- `warehouse`

The method `Main.selectFactory()` returns the correct factory.

After this selection, the business operations work only through abstractions.

An unknown or empty family causes an `IllegalArgumentException`.

## 7. Business Operations

The `SecuritySystem` class contains three realistic operations.

### Arm System

This operation:

1. locks all entrances;
2. starts sensor monitoring;
3. sends an armed-system notification.

### Handle Intrusion

This operation:

1. checks whether the sensor detects the threat;
2. locks the entrances;
3. sends an intrusion alert;
4. notifies the emergency or security service.

### Start Evacuation

This operation:

1. activates sensor monitoring;
2. opens emergency exits;
3. sends an evacuation notification.

Each operation uses products from several product types.

## 8. Adding the Fourth Family

The Warehouse family was added after the original architecture.

### Added Files

- `WarehouseAccessController.java`
- `WarehouseSecuritySensor.java`
- `WarehouseAlertService.java`
- `WarehouseSecurityFactory.java`

### Modified Files

- `Main.java`

Only one case was added to `Main.selectFactory()`:

```java
case "warehouse" -> new WarehouseSecurityFactory();
```

No changes were required in:

- `SecuritySystem`;
- product interfaces;
- `SecuritySystemFactory`;
- existing product families;
- security event products;
- security event creators.

This demonstrates that the architecture is open for extension.

## 9. Testing

The project contains 22 automated JUnit tests.

Tests cover:

- Apartment, Villa and Office families;
- Warehouse family;
- concrete product creation;
- compatible product families;
- runtime selection;
- all three business operations;
- all Factory Method products;
- all concrete Creator classes;
- client operation through abstractions;
- unknown family;
- blank family;
- null factory;
- null security system.

All 22 tests pass successfully.

## 10. UML

The UML source is stored in:

```text
docs/architecture.puml
```

The exported diagram is stored in:

```text
docs/architecture.png
```

The diagram contains separate marked regions for:

- Abstract Factory;
- Factory Method.

It also shows interfaces, concrete products, factories, creators, the client and their relationships.

## 11. Git History

The project was developed in meaningful stages:

1. Initial system without factories.
2. Product interfaces.
3. Abstract Factory implementation.
4. Factory Method implementation.
5. Warehouse product family.
6. Automated tests.
7. UML diagram.
8. Documentation and final project preparation.

## 12. Conclusion

Factory Method separates security event creation from event processing.

Abstract Factory creates compatible groups of security products without connecting the client to concrete classes.

The final architecture has less duplication and lower coupling. It is easier to test and extend with new building families.