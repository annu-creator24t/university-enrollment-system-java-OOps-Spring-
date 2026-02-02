package com.annu.university_enrollment_system.controller;

import com.annu.university_enrollment_system.controller.dto.EnrollmentRequest;
import com.annu.university_enrollment_system.exception.EnrollmentException;
import com.annu.university_enrollment_system.model.Course;
import com.annu.university_enrollment_system.model.Student;
import com.annu.university_enrollment_system.service.EnrollmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller exposing enrollment APIs.
 */
@RestController
@RequestMapping("/api")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    /**
     * POST /api/enroll
     * Enrolls a student into a course
     */
    @PostMapping("/enroll")
    public String enroll(@RequestBody EnrollmentRequest request)
            throws EnrollmentException {

        enrollmentService.enrollStudent(
                request.getStudent(),
                request.getCourse()
        );

        return "Student enrolled successfully";
    }

    /**
     * GET /api/students
     * Returns all enrolled students
     */
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return enrollmentService.getAllStudents();
    }

    /**
     * GET /api/courses
     * Returns all courses
     */
    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return enrollmentService.getAllCourses();
    }
}
