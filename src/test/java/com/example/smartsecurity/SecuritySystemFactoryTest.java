package com.example.smartsecurity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecuritySystemFactoryTest {

    @Test
    void apartmentFactoryCreatesCompatibleProducts() {
        SecuritySystemFactory factory =
                new ApartmentSecurityFactory();

        assertInstanceOf(
                ApartmentAccessController.class,
                factory.createAccessController()
        );
        assertInstanceOf(
                ApartmentSecuritySensor.class,
                factory.createSecuritySensor()
        );
        assertInstanceOf(
                ApartmentAlertService.class,
                factory.createAlertService()
        );
    }

    @Test
    void villaFactoryCreatesCompatibleProducts() {
        SecuritySystemFactory factory =
                new VillaSecurityFactory();

        assertInstanceOf(
                VillaAccessController.class,
                factory.createAccessController()
        );
        assertInstanceOf(
                VillaSecuritySensor.class,
                factory.createSecuritySensor()
        );
        assertInstanceOf(
                VillaAlertService.class,
                factory.createAlertService()
        );
    }

    @Test
    void officeFactoryCreatesCompatibleProducts() {
        SecuritySystemFactory factory =
                new OfficeSecurityFactory();

        assertInstanceOf(
                OfficeAccessController.class,
                factory.createAccessController()
        );
        assertInstanceOf(
                OfficeSecuritySensor.class,
                factory.createSecuritySensor()
        );
        assertInstanceOf(
                OfficeAlertService.class,
                factory.createAlertService()
        );
    }

    @Test
    void warehouseFactoryCreatesCompatibleProducts() {
        SecuritySystemFactory factory =
                new WarehouseSecurityFactory();

        assertInstanceOf(
                WarehouseAccessController.class,
                factory.createAccessController()
        );
        assertInstanceOf(
                WarehouseSecuritySensor.class,
                factory.createSecuritySensor()
        );
        assertInstanceOf(
                WarehouseAlertService.class,
                factory.createAlertService()
        );
    }

    @Test
    void selectsApartmentFactoryAtRuntime() {
        assertInstanceOf(
                ApartmentSecurityFactory.class,
                Main.selectFactory("apartment")
        );
    }

    @Test
    void selectsVillaFactoryAtRuntime() {
        assertInstanceOf(
                VillaSecurityFactory.class,
                Main.selectFactory("villa")
        );
    }

    @Test
    void selectsOfficeFactoryAtRuntime() {
        assertInstanceOf(
                OfficeSecurityFactory.class,
                Main.selectFactory("office")
        );
    }

    @Test
    void selectsWarehouseFactoryAtRuntime() {
        assertInstanceOf(
                WarehouseSecurityFactory.class,
                Main.selectFactory("warehouse")
        );
    }

    @Test
    void armSystemUsesMultipleProducts() {
        SecuritySystem system = new SecuritySystem(
                new ApartmentSecurityFactory()
        );

        String result = system.armSystem();

        assertTrue(result.contains("PIN access"));
        assertTrue(result.contains("monitoring"));
        assertTrue(result.contains("armed"));
    }

    @Test
    void intrusionResponseUsesMultipleProducts() {
        SecuritySystem system = new SecuritySystem(
                new VillaSecurityFactory()
        );

        String result = system.handleIntrusion("intrusion");

        assertTrue(result.contains("Threat detected"));
        assertTrue(result.contains("locked"));
        assertTrue(result.contains("notified"));
    }

    @Test
    void evacuationUsesMultipleProducts() {
        SecuritySystem system = new SecuritySystem(
                new OfficeSecurityFactory()
        );

        String result = system.startEvacuation();

        assertTrue(result.contains("monitoring"));
        assertTrue(result.contains("emergency exits"));
        assertTrue(result.contains("Evacuation"));
    }

    @Test
    void unknownFamilyThrowsException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Main.selectFactory("hotel")
        );
    }

    @Test
    void blankFamilyThrowsException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Main.selectFactory(" ")
        );
    }

    @Test
    void nullFactoryThrowsException() {
        assertThrows(
                NullPointerException.class,
                () -> new SecuritySystem(null)
        );
    }

    @Test
    void clientWorksThroughFactoryAbstraction() {
        SecuritySystemFactory factory =
                new WarehouseSecurityFactory();

        SecuritySystem system = new SecuritySystem(factory);

        assertTrue(
                system.armSystem().contains("Warehouse")
        );
    }
}