package com.example.studentmanagementsystem.controller;
import com.example.studentmanagementsystem.dto.StudentDTO;
import com.example.studentmanagementsystem.entity.Student;
import com.example.studentmanagementsystem.service.StudentService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
public class StudentController
{
    private final StudentService service;

    public StudentController(StudentService service)
    {
        this.service = service;
    }

    //POST - create student
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody StudentDTO dto)
    {
        Student student = new Student();
        student.setName(dto.getName());
        student.setCourse(dto.getCourse());
        student.setEmail(dto.getEmail());

        Student savedStudent = service.create(student);

        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    // GET - fetch all students
    @GetMapping
    public ResponseEntity<List<Student>>
    getAllStudents()
    {
        return ResponseEntity.ok(service.getAll());
    }

    //GET - fetch student by iD
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id)
    {
        return ResponseEntity.ok(service.getById(id));
    }

    //PUT - Update
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody StudentDTO dto)
    {
        Student student = new Student();
        student.setName(dto.getName());
        student.setCourse(dto.getCourse());
        student.setEmail(dto.getEmail());

        return ResponseEntity.ok(service.update(id, student));
    }

    // DELETE - delete student
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id)
    {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
