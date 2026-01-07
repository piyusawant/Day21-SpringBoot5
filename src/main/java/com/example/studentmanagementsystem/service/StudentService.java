package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.dto.StudentDTO;
import com.example.studentmanagementsystem.entity.Student;
import com.example.studentmanagementsystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService
{
    private final StudentRepository repository;

    public StudentService(StudentRepository repository)
    {
        this.repository = repository;
    }

    public Student create(Student student)
    {
        return repository.save(student);
    }
    public List<Student> getAll()
    {
        return repository.findAll();
    }
    public Student getById(Long id)
    {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Student Not Found"));
    }

    public Student update(Long id, Student student)
    {
        Student existing = getById(id);
        existing.setName(student.getName());
        existing.setCourse(student.getCourse());
        existing.setEmail(student.getEmail());
        return repository.save(existing);
    }

    public void delete(Long id)
    {
        repository.deleteById(id);
    }

}
