package org.springframeworkcore.mvc.javaannotationbased.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframeworkcore.mvc.javaannotationbased.dto.request.student.StudentCreateRequestDTO;
import org.springframeworkcore.mvc.javaannotationbased.dto.request.student.StudentLoginRequestDTO;
import org.springframeworkcore.mvc.javaannotationbased.dto.response.student.StudentGetResponseDTO;
import org.springframeworkcore.mvc.javaannotationbased.model.Student;

@Service
public class AuthService {

    private final StudentService studentService;

    @Autowired
    public AuthService(StudentService studentService){
        this.studentService = studentService;
    }

    public void studentLogin(StudentLoginRequestDTO studentLoginRequestDTO) throws Exception{
        if(studentLoginRequestDTO==null){
            throw new Exception("student login credentials null!");
        }
        if(studentLoginRequestDTO.username().isBlank()){
            throw new Exception("student login credentials username is empty!");
        }
        if(studentLoginRequestDTO.password().isBlank()){
            throw new Exception("student login credentials password is empty!");
        }
        if(studentLoginRequestDTO.username().length()<4){
            throw new Exception("student login credentials username is length should be greater than 3!");
        }
        if(studentLoginRequestDTO.password().length()<4){
            throw new Exception("student login credentials password is length should be greater than 3!");
        }
        try{
            StudentGetResponseDTO studentDTOResponse = studentService.findByUsername(studentLoginRequestDTO.username());
            if(!studentDTOResponse.password().equals(studentLoginRequestDTO.password())){
                throw new Exception("student login credentials password is incorrect!");
            }
        }
        catch(Exception e){
            throw e;
        }
    }
}
