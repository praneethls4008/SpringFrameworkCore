package org.springframeworkcore.hibernate.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframeworkcore.jdbc.dao.repo.SQLFunction;
import org.springframeworkcore.jdbc.dao.repo.StudentDAO;
import org.springframeworkcore.jdbc.dao.rowmapper.StudentGroupByAgeResultSetExtractor;
import org.springframeworkcore.jdbc.dao.rowmapper.StudentGroupByResultSetExtractor;
import org.springframeworkcore.jdbc.dao.rowmapper.StudentRowMapper;
import org.springframeworkcore.jdbc.model.Student;

@Repository
//@Transactional for all methods in class
public class StudentDAOImpl implements StudentDAO{

	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	StudentDAOImpl(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void save(Student student) {
		String query = "insert into studentJdbc values(?, ?, ?)";
		jdbcTemplate.update(query, student.getId(), student.getName(), student.getAge());
		
	}

	@Override
	public void delete(int id) {
		String query = "delete from studentJdbc where id=?";
		
		jdbcTemplate.update(query, id);
		
	}

	@Transactional(readOnly = true)
	@Override
	public Student get(int id) {
		String query = "select * from studentJdbc where id=?";
		
		return jdbcTemplate.queryForObject(query, new StudentRowMapper(), id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Student> getAll() {
		String query = "select * from studentJdbc";
		return jdbcTemplate.query(query, new StudentRowMapper());
	}

	@Override
	@Transactional
	public void saveAll(List<Student> studentList) {
		String query = "insert into studentJdbc (name, age) values(?, ?)";
		List<Object[]> args = studentList.stream().map(studentObj -> new Object[] {studentObj.getName(), studentObj.getAge()}).collect(Collectors.toList());
		jdbcTemplate.batchUpdate(query, args);
	}

	@Transactional(readOnly = true)
	@Override
	public Map<Integer, List<String>> groupByStudentAge() {
		String query = "select * from studentJdbc";
		return jdbcTemplate.query(query, new StudentGroupByAgeResultSetExtractor());
	}
	
	
	@Override
	public void cleanTable() {
		String query = "TRUNCATE TABLE studentJdbc";
		jdbcTemplate.execute(query);
	}

	@Transactional(readOnly = true)
	@Override
	public <K, V> Map<K, List<V>> groupBy(
			SQLFunction<ResultSet, K> keyExtractor,
			SQLFunction<ResultSet, V> valueExtractor) {
	    
	    String query = "select * from studentJdbc";
	    return jdbcTemplate.query(query, new StudentGroupByResultSetExtractor<>(keyExtractor, valueExtractor));
	}
	
	
	@Transactional(readOnly = false)
	public void saveOne(Student student) {
		String query = "insert into studentJdbc values(?, ?, ?)";
		jdbcTemplate.update(query, student.getId(), student.getName(), student.getAge());
		
	}
	
	
	
	@Transactional(readOnly = false)
	public Student saveOneAndGet(Student student) {
		String query = "insert into studentJdbc values(?, ?, ?)";
		jdbcTemplate.update(query, student.getId(), student.getName(), student.getAge());
		Student s = new Student();
		try {
			s = getOne(2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s ;
	}
	
	@Transactional(readOnly = true)
	public Student getOne(int id) throws Exception{
		String query = "select * from studentJdbc where id=?";
		return jdbcTemplate.queryForObject(query, new StudentRowMapper(), id);
	
	}
	
	@Override
	@Transactional(readOnly = false)
	public void saveMany(List<Student> studentList, int id) {
		for(Student student: studentList) {
			saveOne(student);
			try {
				getOne(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
}
