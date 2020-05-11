

package com.example.demo.repositories;



import com.example.demo.models.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class InMemoryStudentRepositoryImpl implements IStudentRepository {
    private List<StudentDTO> inMemoryDB;

    public InMemoryStudentRepositoryImpl(){
        this.inMemoryDB = new ArrayList<StudentDTO>(
                Arrays.asList(
                        new StudentDTO(1, "Maria", "Wagner", new Date(24121982), "123456"),
                        new StudentDTO(1, "Maria", "Wagner", new Date(24121982), "456757"),
                        new StudentDTO(3, "Johan", "Flux", new Date(13021987), "57484847")
                )
        );
    }

    @Override
    public void create(StudentDTO studentDTO){
        inMemoryDB.add(studentDTO);
    }

    @Override
    public StudentDTO read(int id) {
        for(StudentDTO stu : inMemoryDB){
            if(stu.getId() == id){
                return stu;
            }
        }
        return null;
    }

    @Override
    public List<StudentDTO> readAll(){
        return inMemoryDB;
    }

    @Override
    public void update(StudentDTO studentDTO){
    }

    /*
    @Override
    public boolean delete(int id) {
        return false;
    }
    */

    @Override
    public void delete(int id) {
        StudentDTO deleteStudentDTO = read(id);
        inMemoryDB.remove(deleteStudentDTO);
    }

}