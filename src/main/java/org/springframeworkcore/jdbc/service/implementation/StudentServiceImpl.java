package org.springframeworkcore.jdbc.service.implementation;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframeworkcore.jdbc.dao.repo.SQLFunction;
import org.springframeworkcore.jdbc.dao.repo.StudentDAO;
import org.springframeworkcore.jdbc.model.Student;
import org.springframeworkcore.jdbc.service.define.StudentService;
import org.springframeworkcore.mvc.javaannotationbased.config.DataBaseConfig;

@Service
public class StudentServiceImpl implements StudentService{
	
	private StudentDAO studentDao; 
	
	@Autowired
	StudentServiceImpl(StudentDAO studentDao){
		this.studentDao = studentDao;
	}
	
	@Override
	public void save(Student student) {
		studentDao.save(student);
	}

	@Override
	public void delete(int id) {
		studentDao.delete(id);
		
	}

	@Override
	public Student get(int id) {
		return studentDao.get(id);
	}

	@Override
	public List<Student> getAll() {
		return studentDao.getAll();
	}

	@Override
	public void saveAll(List<Student> studentList) {
		studentDao.saveAll(studentList);
		
	}

	@Override
	public Map<Integer, List<String>> groupByStudentAge() {
		return studentDao.groupByStudentAge();
	}

	@Override
	public <K, V> Map<K, List<V>> groupBy(SQLFunction<ResultSet, K> keyExtractor, SQLFunction<ResultSet, V> valueExtractor){
		return studentDao.groupBy(keyExtractor, valueExtractor);
	}

	
	
	
}
