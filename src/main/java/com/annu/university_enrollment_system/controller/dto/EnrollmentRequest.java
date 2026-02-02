package com.annu.university_enrollment_system.controller.dto;

import com.annu.university_enrollment_system.model.Course;
import com.annu.university_enrollment_system.model.Student;

public class EnrollmentRequest {

    private Student student;
    private Course course;

    public EnrollmentRequest() {}

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
