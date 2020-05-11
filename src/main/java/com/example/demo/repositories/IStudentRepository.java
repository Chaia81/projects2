package com.example.demo.repositories;

import com.example.demo.models.StudentDTO;

import java.util.List;

public interface IStudentRepository {
    // CRUD operations
    public void create(StudentDTO student);

    public StudentDTO read(int id);

    public List<StudentDTO> readAll();

    public void update(StudentDTO studentDTO);

    public void delete(int id);
}