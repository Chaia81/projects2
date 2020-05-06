package com.example.demo.repositories;

import com.example.demo.models.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class InMemoryStudentReposImpl implements IStudentRepos{
    private List<Student> inMemoryDB;

    public InMemoryStudentReposImpl(){
        this.inMemoryDB = new ArrayList<Student>(
                Arrays.asList(
                        new Student(1, "Maria", "Wagner", new Date(24121982)),
                        new Student(2, "Maria", "Wagner", new Date(20190816)),
                        new Student(3, "Johan", "Flux", new Date(13021987))
                )
        );
    }

    @Override
    public boolean create(Student student){
        return false;
    }

    @Override
    public Student read(int id) {
        for(Student stu : inMemoryDB){
            if(stu.getId() == id){
                return stu;
            }
        }
        return null;
    }

    @Override
    public List<Student> readAll(){
        return inMemoryDB;
    }

    @Override
    public boolean update(Student student){
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}