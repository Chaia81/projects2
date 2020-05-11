package com.example.demo.controllers;

import com.example.demo.models.StudentDTO;
import com.example.demo.repositories.IStudentRepository;
import com.example.demo.repositories.StudentRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
public class StudentController {

    private IStudentRepository studentRepository;

    @Autowired
    public StudentController(){
        studentRepository = new StudentRepositoryImpl();
    }

    @GetMapping("/overview")
    public String overview(Model model){
        model.addAttribute("student" , studentRepository.readAll());
        return "student/overview";
    }

    @GetMapping("/createStudent")
    public String createStudent(Model model){
        model.addAttribute("student", new StudentDTO());
        return "student/createStudent";
    }

    @PostMapping("/createStudent")
    public String saveStudent(@ModelAttribute StudentDTO student){
        studentRepository.create(student);
        return "redirect:/overview";
    }

    @GetMapping("/details")
    public String details(Model model, @RequestParam int id){
        StudentDTO stu = studentRepository.read(id);
        model.addAttribute("student", stu);
        return "student/details";
    }

    @GetMapping("/deleteStudent")
    public String deleteStud(Model model, @RequestParam int id){
        StudentDTO stu = studentRepository.read(id);
        model.addAttribute("student", stu);
        return "student/deleteStudent";
    }

    @PostMapping ("student/deleteStudent")
    public String deleteForGood(int id) {
        studentRepository.delete(id);
        return "redirect:/overview";
    }


    @GetMapping("/updateStudent")
    public String edit(Model model, @RequestParam int id){
        StudentDTO stu = studentRepository.read(id);
        model.addAttribute("student", stu);
        return "student/updateStudent";
    }

    @PostMapping("/updateStudent")
    public String edit(@ModelAttribute StudentDTO student){
        studentRepository.update(student);
        return "redirect:/overview";
    }


    //Very simple prototype of GET-request with parameter
    //https://www.baeldung.com/spring-request-param
    //TODO Direct to detailed view of student
    @GetMapping("/student")
    @ResponseBody
    public String getStudentByParameter(@RequestParam int id) {
        StudentDTO stu = studentRepository.read(id);
        return "id: " + stu.getId() + "\n" + stu.getFirstName() + "\n" + stu.getLastName() + "\n" + stu.getCpr() + "\n" + stu.getEnrollmentDate();
    }


}