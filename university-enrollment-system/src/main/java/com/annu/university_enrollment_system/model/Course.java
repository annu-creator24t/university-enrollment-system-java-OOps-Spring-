package com.annu.university_enrollment_system.model;
import com.annu.university_enrollment_system.exception.EnrollmentException;




import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a Course in the University Enrollment System.
 *
 * OOPS Concepts Used:
 * 1. Encapsulation  – Course data is protected from direct modification.
 * 2. Composition   – Course HAS-A Professor and multiple Students.
 * 3. Abstraction   – Focuses on course behavior, not UI logic.
 * 4. Exception Handling – Enforces enrollment constraints using custom exceptions.
 */
public class Course {

    // Core course identity fields (immutable)
    private final String courseName;
    private final String courseCode;

    // Aggregation: Course has an instructor, but does not own Professor lifecycle
    private Professor instructor;

    // Maximum number of students allowed in the course
    private final int maxCapacity;

    // List to maintain enrolled students
    private final List<Student> enrolledStudents;

    /**
     * Constructs a Course with validated parameters.
     *
     * @param courseName   Name of the course
     * @param courseCode   Unique course code
     * @param instructor   Assigned professor (can be null initially)
     * @param maxCapacity  Maximum allowed students (> 0)
     */
    public Course(String courseName, String courseCode,
                  Professor instructor, int maxCapacity) {

        // Defensive validation
        if (courseName == null || courseName.trim().isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be empty");
        }
        if (courseCode == null || courseCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Course code cannot be empty");
        }
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("Max capacity must be greater than zero");
        }

        this.courseName = courseName;
        this.courseCode = courseCode;
        this.instructor = instructor;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = new ArrayList<>();
    }

    /**
     * Enrolls a student into the course.
     *
     * Business Rules:
     * - Course must not exceed maximum capacity
     * - Student must not be enrolled twice
     *
     * @param student Student to be enrolled
     * @throws EnrollmentException if enrollment rules are violated
     */
    public void enrollStudent(Student student) throws EnrollmentException {

        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }

        // Prevent duplicate enrollment
        if (enrolledStudents.contains(student)) {
            throw new EnrollmentException("Student already enrolled in " + courseCode);
        }

        // Capacity check
        if (enrolledStudents.size() >= maxCapacity) {
            throw new EnrollmentException("Course " + courseCode + " is full");
        }

        enrolledStudents.add(student);
    }

    /**
     * Returns an unmodifiable list of enrolled students.
     * Prevents external modification of internal data.
     */
    public List<Student> getEnrolledStudents() {
        return Collections.unmodifiableList(enrolledStudents);
    }

    /**
     * Assigns or updates the instructor for this course.
     */
    public void setInstructor(Professor instructor) {
        this.instructor = instructor;
    }

    /**
     * Returns basic course information in a readable format.
     */
    @Override
    public String toString() {
        return "Course [Code=" + courseCode +
               ", Name=" + courseName +
               ", Instructor=" + (instructor != null ? instructor.getName() : "TBD") +
               ", Enrolled=" + enrolledStudents.size() +
               "/" + maxCapacity + "]";
    }
}
