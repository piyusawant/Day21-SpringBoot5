package com.example.studentmanagementsystem.repository;

import com.example.studentmanagementsystem.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository

public class StudentRepository
{
    private final Map<Long, Student> db = new HashMap<>();

    private long idCounter = 1;

    public List<Student> findAll()
    {
        return new ArrayList<>(db.values());
    }
    public Student findById(Long id)
    {
        return db.get(id);
    }

    public Student save(Student student)
    {
        student.setId(idCounter++);
        db.put(student.getId(), student);
        return student;
    }

    public Student update(Long id, Student student)
    {
        student.setId(id);
        db.put(id, student);
        return student;
    }

    public void delete(Long id)
    {
        db.remove(id);
    }
}
