package org.springframeworkcore.jdbc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframeworkcore.jdbc.config.BaseConfig;
import org.springframeworkcore.jdbc.model.Student;
import org.springframeworkcore.jdbc.service.define.StudentService;

public class mainApp {
	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				BaseConfig.class);
		StudentService studentService = applicationContext.getBean(StudentService.class);

		
//		  Student student1 = new Student(); student1.setName("idiot3");
//		  student1.setAge(18);
//		 
//		  Student student2 = new Student(); student2.setName("rand2");
//		  student2.setAge(17);
//		  
//		  Student student3 = new Student(); student3.setName("random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3");
//		  student3.setAge(15);
//		  
//		  
//		  studentService.saveAll(new ArrayList<>(Arrays.asList(student1, student2,student3)));
		 
//		Map<String, List<Student>> map = studentService.groupBy(rs -> rs.getString("name"), rs -> {
//			return new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"));
//		});
//		
//		System.out.println("groupBy:\n");
//		for(Entry<String, List<Student>> entry: map.entrySet()) {
//			System.out.println("Key-> "+entry.getKey());
//			System.out.println("Values-> "+entry.getValue());
//		}
//		
//		System.out.println("groupByAge:\n" + studentService.groupByStudentAge());
//		System.out.println("getall:\n" + studentService.getAll());
//		System.out.println("by id:\n" + studentService.get(13));
		
		  
		  Student student1 = new Student(); student1.setName("idiot3");
		  student1.setAge(18);
		 
		  Student student2 = new Student(); student2.setName("rand2");
		  student2.setAge(17);
		  
		  String name = "hello";
//		  name = "random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3random3";
		  Student student3 = new Student(); student3.setName(name);
		  student3.setAge(15);
		 
		  
		  
		studentService.cleanTable();
		System.out.println("output"+studentService.transaction(new ArrayList<>(Arrays.asList(student1, student2,student3)), 100));
		
		applicationContext.close();
	}
}
