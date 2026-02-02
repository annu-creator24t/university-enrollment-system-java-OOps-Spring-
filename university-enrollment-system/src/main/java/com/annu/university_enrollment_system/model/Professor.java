package com.annu.university_enrollment_system.model;



/**
 * Represents a Professor in the University Enrollment System.
 * 
 * OOPS Concepts Used:
 * 1. Inheritance   – Professor extends the abstract Person class.
 * 2. Encapsulation – Department field is kept private.
 * 3. Polymorphism  – Implements role-specific behavior from Person.
 * 4. Abstraction   – Focuses on professor identity, not UI logic.
 */
public class Professor extends Person {

    // Academic department the professor belongs to
    // Kept immutable after object creation
    private final String department;

    /**
     * Constructs a Professor object with validated personal and professional details.
     *
     * @param name       Professor name (validated in Person)
     * @param email      Professor email (validated in Person)
     * @param department Academic department (cannot be null or empty)
     */
    public Professor(String name, String email, String department) {
        super(name, email); // Call to superclass constructor

        // Validate department to maintain data integrity
        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Department cannot be null or empty");
        }

        this.department = department;
    }

    /**
     * Returns the academic department of the professor.
     * Demonstrates encapsulation with controlled access.
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Polymorphic behavior implementation.
     * Defines the role of this Person as a Professor.
     */
    @Override
    public String getRole() {
        return "Professor";
    }

    /**
     * Provides a readable string representation of a Professor object.
     * Useful for debugging, logging, and console output.
     */
    @Override
    public String toString() {
        return "Professor [Name=" + name +
               ", Email=" + email +
               ", Department=" + department + "]";
    }
}
