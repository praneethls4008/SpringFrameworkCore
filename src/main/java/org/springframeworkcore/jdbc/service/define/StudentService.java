package org.springframeworkcore.jdbc.service.define;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.springframeworkcore.jdbc.dao.repo.SQLFunction;
import org.springframeworkcore.jdbc.model.Student;

public interface StudentService {
	void save(Student student);
	void saveAll(List<Student> studentList);
	void delete(int id);
	Student get(int id);
	List<Student> getAll();
	Map<Integer, List<String>> groupByStudentAge();
	<K, V> Map<K, List<V>> groupBy(SQLFunction<ResultSet, K> keyExtractor, SQLFunction<ResultSet, V> valueExtractor);
	List<Student> transaction(List<Student> studentList, int id);
	void cleanTable();
	
}
