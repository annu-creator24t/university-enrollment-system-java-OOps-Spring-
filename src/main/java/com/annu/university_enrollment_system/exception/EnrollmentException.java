package com.annu.university_enrollment_system.exception;





/**
 * Custom checked exception used to indicate enrollment-related failures.
 *
 * This exception is thrown when business rules are violated, such as:
 * - Course capacity being exceeded
 * - Duplicate student enrollment
 *
 * Using a custom exception improves readability, maintainability,
 * and enforces explicit error handling.
 */
public class EnrollmentException extends Exception {

    /**
     * Constructs an EnrollmentException with a descriptive message.
     *
     * @param message Explanation of the enrollment failure
     */
    public EnrollmentException(String message) {
        super(message);
    }

    /**
     * Constructs an EnrollmentException with a message and root cause.
     * Useful for exception chaining in larger systems.
     *
     * @param message Explanation of the enrollment failure
     * @param cause   Root cause of the exception
     */
    public EnrollmentException(String message, Throwable cause) {
        super(message, cause);
    }
}
