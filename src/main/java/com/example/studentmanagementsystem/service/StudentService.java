package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.dto.StudentDTO;
import com.example.studentmanagementsystem.entity.Student;
import com.example.studentmanagementsystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public class StudentService
{
    private final StudentRepository repository;

    public StudentService(StudentRepository repository)
    {
        this.repository = repository;
    }
    public List<Student> getAllStudents()
    {
        return repository.findAll();
    }
    public Student getStudent(Long id)
    {
        return repository.findById(id);
    }
    public Student createStudent(StudentDTO dto)
    {
        Student student = new Student(null, dto.getName(), dto.getCourse(), dto.getEmail());
        return repository.save(student);
    }
    public Student updateStudent(Long id, StudentDTO dto)
    {
        Student student = new Student(id, dto.getName(), dto.getCourse(), dto.getEmail());
        return repository.update(id, student);
    }
    public void deleteStudent(Long id)
    {
        repository.delete(id);
    }

}
