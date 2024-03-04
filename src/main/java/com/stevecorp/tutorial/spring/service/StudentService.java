package com.stevecorp.tutorial.spring.service;

import com.stevecorp.tutorial.spring.model.Student;
import com.stevecorp.tutorial.spring.repository.StudentRepository;
import com.stevecorp.tutorial.spring.service.exception.StudentNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getStudent(final long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    public Page<Student> getStudentsWithAddressInCity(
            final String zipCode,
            final Pageable pageable
    ) {
        return studentRepository.findAllByAddressesZip(zipCode, pageable);
    }

    public Page<Student> getStudentsBornInYear(
            final int year,
            final Pageable pageable
    ) {
        return studentRepository.findAllBornInYear(year, pageable);
    }

    public Page<Student> getAllStudents(final Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    public void addStudent(final Student student) {
        studentRepository.save(student);
    }

    public void addStudents(final List<Student> students) {
        studentRepository.saveAll(students);
    }

    public void updateStudent(final long id, final Student student) {
        final boolean studentExists = studentRepository.existsById(id);
        if (!studentExists) {
            throw new StudentNotFoundException(id);
        }
        student.setId(id);
        studentRepository.save(student);
    }

    public void deleteStudent(final long id) {
        studentRepository.deleteById(id);
    }

    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }

}
