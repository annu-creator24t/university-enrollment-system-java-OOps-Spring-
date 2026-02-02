package com.annu.university_enrollment_system.model;



import java.io.Serializable;

/**
 * Abstract base class representing a generic person in the university system.
 * 
 * OOPS Concepts Used:
 * 1. Abstraction  – Prevents direct instantiation and enforces role-specific behavior.
 * 2. Encapsulation – Protects core identity fields.
 * 3. Inheritance  – Acts as a superclass for Student and Professor.
 * 4. Polymorphism – Enforces runtime behavior through abstract methods.
 */
public abstract class Person implements Serializable {

    // Encapsulated identity fields shared by all subclasses
    // 'protected' allows access to child classes while restricting external access
    protected final String name;
    protected final String email;

    /**
     * Parameterized constructor to enforce mandatory fields and object validity.
     * Defensive programming is used to prevent creation of invalid objects.
     *
     * @param name  Name of the person (cannot be null or empty)
     * @param email Email of the person (basic validation applied)
     */
    public Person(String name, String email) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.name = name;
        this.email = email;
    }

    /**
     * Getter method for name.
     * Demonstrates encapsulation by providing controlled access.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for email.
     * Encapsulation ensures the field is not accessed directly.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Provides a readable string representation of a Person object.
     * Useful for logging, debugging, and clean console output.
     */
    @Override
    public String toString() {
        return "Name: " + name + ", Email: " + email;
    }

    /**
     * Abstract method to enforce role-specific behavior in subclasses.
     * Each subclass must define how its role is represented.
     *
     * Example:
     * Student   -> "Student"
     * Professor -> "Professor"
     */
    public abstract String getRole();
}
