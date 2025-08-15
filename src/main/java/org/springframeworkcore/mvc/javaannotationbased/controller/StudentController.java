package org.springframeworkcore.mvc.javaannotationbased.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframeworkcore.mvc.javaannotationbased.dto.request.student.StudentCreateRequestDTO;
import org.springframeworkcore.mvc.javaannotationbased.implementation.StudentServiceImplementation;
import org.springframeworkcore.mvc.javaannotationbased.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframeworkcore.mvc.javaannotationbased.service.AuthService;
import org.springframeworkcore.mvc.javaannotationbased.service.StudentService;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
    StudentService studentService;
    AuthService authService;

    @Autowired
    public StudentController(StudentService studentService, AuthService authService){
        this.studentService = studentService;
        this.authService = authService;
    }

    @GetMapping("")
    public String studentLoginPage(){
        return "studentLoginPage";
    }

    @PostMapping("/auth")
    public String studentAuthPage(@ModelAttribute StudentCreateRequestDTO studentDTO){
        try{
            authService.studentLogin(studentDTO);
        }catch (Exception authException){
            authException.printStackTrace();
            return "redirect:/student";
        }
        return "redirect:/student/?username="+studentDTO.username();

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
    public String studentNewAccount(@ModelAttribute StudentCreateRequestDTO studentRequestDTO){
        try{
            studentService.save(studentRequestDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/student/register";
        }
        return "studentLoginPage";
    }



}
