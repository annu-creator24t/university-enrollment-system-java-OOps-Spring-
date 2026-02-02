🎓 University Enrollment System (Spring Boot):-

A backend RESTful API built using Spring Boot that manages student enrollments into university courses.
The project demonstrates strong OOP principles, clean architecture, and API documentation using Swagger UI.


🚀 Features:-

Enroll students into courses
View all enrolled students
View all available courses
In-memory data storage (no database required)
REST APIs documented using Swagger (OpenAPI)
Clean layered architecture (Controller → Service → Model)


🛠️ Tech Stack:-

Java 17+
Spring Boot
Maven
Swagger / OpenAPI
Embedded Tomcat


🧠 OOP Concepts Used:-

Encapsulation – Private fields with controlled access
Inheritance – Student and Professor extend Person
Abstraction – Service layer hides business logic
Polymorphism – Common behavior via base classes
Exception Handling – Custom EnrollmentException


📂 Project Structure:-

src/main/java/com/annu/university_enrollment_system
│
├── controller
│   ├── EnrollmentController.java
│   └── dto
│       └── EnrollmentRequest.java
│
├── service
│   └── EnrollmentService.java
│
├── model
│   ├── Person.java
│   ├── Student.java
│   ├── Professor.java
│   └── Course.java
│
├── exception
│   └── EnrollmentException.java
│
└── UniversityEnrollmentSystemApplication.java

Run the Application:-
./mvnw spring-boot:run


Open Swagger UI:-
http://localhost:8080/swagger-ui.html


🔌 API Endpoints
➤ Enroll a Student

POST /api/enroll

{
  "student": {
    "name": "Aarav Sharma",
    "email": "aarav@univ.edu",
    "cgpa": 9.1
  },
  "course": {
    "courseName": "Java OOPS",
    "courseCode": "JV007",
    "maxCapacity": 3
  }
}


➤ Get All Students
GET /api/students

➤ Get All Courses
GET /api/courses

🧪 Testing

All APIs are tested locally using Swagger UI, which provides:
Request/response visualization
JSON schema validation
Easy API exploration

📌 Future Enhancements:-

Add database support (MySQL / PostgreSQL)
Add authentication & authorization
Add update/delete APIs
Deploy to cloud (Render / Railway)

👨‍💻 Author:-

Annu Tiwari
Backend Developer | Java | Spring Boot


⭐ Why This Project Matters
This project demonstrates:

1-Practical backend development skills
2-Real-world API design
3-Strong understanding of Java OOP
4-Clean and scalable code structure