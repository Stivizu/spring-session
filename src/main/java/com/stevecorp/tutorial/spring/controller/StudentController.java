package com.stevecorp.tutorial.spring.controller;

import com.stevecorp.tutorial.spring.model.Student;
import com.stevecorp.tutorial.spring.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.stevecorp.tutorial.spring.util.StudentGenerator.generateStudent;

@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{student_id}")
    public ResponseEntity<Student> getStudent(
            @PathVariable(name = "student_id") final long studentId
    ) {
        final Student student = studentService.getStudent(studentId);
        return ResponseEntity.ok(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(
            @RequestParam(name = "city_zip", required = false) final String cityZip,
            @RequestParam(name = "year_of_birth", required = false) final Integer yearOfBirth
    ) {
        final List<Student> students;
        if (cityZip != null) {
            students = studentService.getStudentsWithAddressInCity(cityZip);
        } else if (yearOfBirth != null) {
            students = studentService.getStudentsBornInYear(yearOfBirth);
        } else {
            students = studentService.getAllStudents();
        }
        return ResponseEntity.ok(students);
    }

    @PostMapping
    public ResponseEntity<Void> addStudent(
            /*
                The @Valid annotation triggers all the validators (both existing and custom)
             */
            @Valid @RequestBody final Student student
    ) {
        /*
            Note that for insurance purposes, we also set the student field in the addresses.
             This way we don't have to do it in the HTTP request.
             This could also easily be aligned with the frontend.
         */
        student.getAddresses().forEach(address -> address.setStudent(student));
        studentService.addStudent(student);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/generate")
    public ResponseEntity<Void> addGeneratedStudent() {
        final Student generatedStudent = generateStudent();
        studentService.addStudent(generatedStudent);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/{student_id}")
    public ResponseEntity<Void> updateStudent(
            @PathVariable(name = "student_id") final long studentId,
            @Valid @RequestBody final Student student
    ) {
        student.getAddresses().forEach(address -> address.setStudent(student));
        studentService.updateStudent(studentId, student);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{student_id}")
    public ResponseEntity<Void> deleteStudent(
            @PathVariable(name = "student_id") final long studentId
    ) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllStudents() {
        studentService.deleteAllStudents();
        return ResponseEntity.noContent().build();
    }

}
