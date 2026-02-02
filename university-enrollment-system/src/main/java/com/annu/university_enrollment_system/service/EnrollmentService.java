package com.annu.university_enrollment_system.service;

import com.annu.university_enrollment_system.exception.EnrollmentException;
import com.annu.university_enrollment_system.model.Course;
import com.annu.university_enrollment_system.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service layer containing business logic
 * and in-memory storage for courses and students.
 */
@Service
public class EnrollmentService {

    // In-memory storage (acts like a temporary database)
    private final List<Student> students = new ArrayList<>();
    private final List<Course> courses = new ArrayList<>();

    /**
     * Enroll a student into a course.
     */
    public void enrollStudent(Student student, Course course)
            throws EnrollmentException {

        if (student == null || course == null) {
            throw new IllegalArgumentException("Student or Course cannot be null");
        }

        course.enrollStudent(student);

        // Store if not already present
        if (!students.contains(student)) {
            students.add(student);
        }
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    /**
     * Get all enrolled students.
     */
    public List<Student> getAllStudents() {
        return students;
    }

    /**
     * Get all courses.
     */
    public List<Course> getAllCourses() {
        return courses;
    }
}
