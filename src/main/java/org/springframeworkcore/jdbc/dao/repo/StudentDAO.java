package org.springframeworkcore.jdbc.dao.repo;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import org.springframeworkcore.jdbc.model.Student;


public interface StudentDAO {
	
	void save(Student student);
	void saveAll(List<Student> studentList);
	void delete(int id);
	Student get(int id);
	List<Student> getAll();
	Map<Integer, List<String>> groupByStudentAge();
	<K, V> Map<K, List<V>> groupBy(SQLFunction<ResultSet, K> keyExtractor,SQLFunction<ResultSet, V> valueExtractor);
	
}
