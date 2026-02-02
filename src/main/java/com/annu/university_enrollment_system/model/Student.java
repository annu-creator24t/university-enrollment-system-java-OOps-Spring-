package com.annu.university_enrollment_system.model;


/**
 * Represents a Student in the University Enrollment System.
 * 
 * OOPS Concepts Used:
 * 1. Inheritance   – Student extends the abstract Person class.
 * 2. Encapsulation – Student-specific data is kept private.
 * 3. Polymorphism  – Overrides abstract behavior from Person.
 * 4. Abstraction   – Focuses on "what a student is", not UI logic.
 */
public class Student extends Person {

    // Static counter to generate unique student IDs
    // Shared across all Student objects
    private static int idCounter = 1000;

    // Unique student identifier (immutable once assigned)
    private final String studentId;

    // Academic performance metric
    private double cgpa;

    /**
     * Constructs a Student object with validated personal and academic details.
     *
     * @param name  Student name (validated in Person)
     * @param email Student email (validated in Person)
     * @param cgpa  Student CGPA (must be between 0.0 and 10.0)
     */
    public Student(String name, String email, double cgpa) {
        super(name, email); // Call to abstract superclass constructor

        // Validate CGPA to maintain data integrity
        if (cgpa < 0.0 || cgpa > 10.0) {
            throw new IllegalArgumentException("CGPA must be between 0.0 and 10.0");
        }

        this.cgpa = cgpa;
        this.studentId = "S" + (++idCounter); // Auto-generate student ID
    }

    /**
     * Returns the unique student ID.
     * Demonstrates encapsulation with controlled access.
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * Returns the CGPA of the student.
     */
    public double getCgpa() {
        return cgpa;
    }

    /**
     * Polymorphic behavior implementation.
     * Defines the role of this Person as a Student.
     */
    @Override
    public String getRole() {
        return "Undergraduate Student";
    }

    /**
     * Provides a readable string representation of a Student object.
     * Useful for debugging, logging, and console display.
     */
    @Override
    public String toString() {
        return "Student [ID=" + studentId +
               ", Name=" + name +
               ", Email=" + email +
               ", CGPA=" + cgpa + "]";
    }
}
