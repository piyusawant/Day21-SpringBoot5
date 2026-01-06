package com.example.studentmanagementsystem.entity;


public class Student
{
    private Long id;
    private String name;
    private String course;
    private String email;

    public Student()
    {

    }
    public Student(Long id, String name, String course, String email)
    {
        this.id = id;
        this.name = name;
        this.course = course;
        this.email = email;
    }
    //Getters and Setters

    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getCourse()
    {
        return course;
    }
    public void setCourse(String course)
    {
        this.course = course;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
}
