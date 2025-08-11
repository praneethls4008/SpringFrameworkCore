package org.springframeworkcore.mvc.javaannotationbased.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframeworkcore.mvc.javaannotationbased.implementation.StudentServiceImplementation;
import org.springframeworkcore.mvc.javaannotationbased.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframeworkcore.mvc.javaannotationbased.service.StudentService;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("")
    public String studentLoginPage(){
        return "studentLoginPage";
    }

    @PostMapping("/auth")
    public String studentAuthPage(@ModelAttribute Student student){
        if(student==null || student.getUsername().isEmpty() || student.getPassword().isEmpty() || student.getPassword().length()<4 || !studentService.findByUsername(student.getUsername()).isPresent() || !studentService.findByUsername(student.getUsername()).get().getPassword().equals(student.getPassword())){
            return "redirect:/student";
        }
        return "redirect:/student/?username="+student.getUsername();

    }

    @GetMapping("/")
    public ModelAndView studentDashBoardPage(@RequestParam("username") String username){
        return new ModelAndView("studentDashboardPage", "username", username);
    }

    @GetMapping("/register")
    public String studentRegisterPage(){
        return "studentRegisterPage";
    }

    @PostMapping("/newaccount")
    public String studentNewAccount(@ModelAttribute Student student){
        if(student==null || student.getUsername().isEmpty() || student.getPassword().isEmpty() || student.getPassword().length()<4 || studentService.findByUsername(student.getUsername()).isPresent()){
            return "redirect:/student/register";
        }
        studentService.save(student);
        return "studentLoginPage";
    }



}
