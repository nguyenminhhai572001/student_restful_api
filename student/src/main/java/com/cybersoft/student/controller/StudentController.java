package com.cybersoft.student.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cybersoft.student.pojo.Student;

@RestController
@RequestMapping("student")
public class StudentController {
private ArrayList<Student> students = new ArrayList<Student>();
	
	@PostMapping("/updateparam")
	public ResponseEntity<ArrayList<Student>>  updateStudent(@RequestParam("name") String name, @RequestParam("age") int age) {
		Student student = new Student();
		student.setName(name);
		student.setAge(age);
		students.add(student);
		return new ResponseEntity<ArrayList<Student>>(students, HttpStatus.OK);
	}	
	
	@PostMapping("/updatepath/{name}/{age}")
	public ResponseEntity<ArrayList<Student>> updateStudent1(@PathVariable("name") String name, @PathVariable("age") int age) {
		
		Student student = new Student();
		student.setName(name);
		student.setAge(age);
		students.add(student);
		return new ResponseEntity<ArrayList<Student>>(students, HttpStatus.OK);
	}
	
	@PostMapping(value = "/updatebody", consumes = "application/json")
	public ResponseEntity<ArrayList<Student>> updateStudent2(@RequestBody Student student) {
		
		students.add(student);
		return new ResponseEntity<ArrayList<Student>>(students, HttpStatus.OK);
	}
}
