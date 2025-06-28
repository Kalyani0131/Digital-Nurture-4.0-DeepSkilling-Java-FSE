package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        // Arrange - Setup before each test
        calculator = new Calculator();
        System.out.println("Setup complete");
    }

    @AfterEach
    public void tearDown() {
        calculator = null;
        System.out.println("Teardown complete");
    }

    @Test
    public void testAdd() {
        // Arrange
        int a = 2;
        int b = 3;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(5, result);
    }

    @Test
    public void testSubtract() {
        // Arrange
        int a = 5;
        int b = 2;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(3, result);
    }
}
