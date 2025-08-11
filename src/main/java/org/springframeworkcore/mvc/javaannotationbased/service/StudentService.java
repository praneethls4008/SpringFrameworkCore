package org.springframeworkcore.mvc.javaannotationbased.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframeworkcore.mvc.javaannotationbased.dao.StudentRepository;
import org.springframeworkcore.mvc.javaannotationbased.model.Student;

import java.util.List;
import java.util.Optional;


public interface StudentService{
    Student save(Student student);
    List<Student> getAllStudents();
    Optional<Student> findByUsername(String username);
}
