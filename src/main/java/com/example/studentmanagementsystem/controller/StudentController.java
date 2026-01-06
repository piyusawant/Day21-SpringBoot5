package com.example.studentmanagementsystem.controller;
import com.example.studentmanagementsystem.dto.StudentDTO;
import com.example.studentmanagementsystem.entity.Student;
import com.example.studentmanagementsystem.service.StudentService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController
{
    private final StudentService service;

    public StudentController(StudentService service)
    {
        this.service = service;
    }
    // GET - fetch aal students
    @GetMapping
    public ResponseEntity<List<Student>>
    getAllStudents()
    {
        return ResponseEntity.ok(service.getAllStudents());
    }

    //GET - fetch student by iD
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id)
    {
        Student student = service.getStudent(id);
        return student != null ? ResponseEntity.ok(student) : ResponseEntity.notFound().build();
    }

    //POST - create student
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody StudentDTO dto)
    {
        Student created = service.createStudent(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    //PUT - Update
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody StudentDTO dto)
    {
        return ResponseEntity.ok(service.updateStudent(id, dto));
    }

    // DELETE - delete student
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id)
    {
        service.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
