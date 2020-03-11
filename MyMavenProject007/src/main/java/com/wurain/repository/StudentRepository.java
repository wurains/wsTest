package com.wurain.repository;

import java.util.Collection;

import com.wurain.model.Student;

public interface StudentRepository {

    public Collection<Student> findAll();
    public Student findById(long id);
    public void saveOrUpdate(Student student);
    public void deleteById(long id);
}
