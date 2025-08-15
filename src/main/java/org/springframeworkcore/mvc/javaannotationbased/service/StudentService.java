package org.springframeworkcore.mvc.javaannotationbased.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframeworkcore.mvc.javaannotationbased.dao.StudentRepository;
import org.springframeworkcore.mvc.javaannotationbased.dto.request.student.StudentCreateRequestDTO;
import org.springframeworkcore.mvc.javaannotationbased.dto.response.student.StudentGetResponseDTO;
import org.springframeworkcore.mvc.javaannotationbased.model.Student;

import java.util.List;


public interface StudentService{
    StudentGetResponseDTO save(StudentCreateRequestDTO student) throws Exception;
    List<Student> getAllStudents();
    StudentGetResponseDTO findByUsername(String username) throws Exception;
}
