package com.start.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.start.demo.model.Student;
import com.start.demo.repository.StudentRepository;
import com.sun.el.stream.Optional;

@RestController
public class StudentController {
	
	
	
	@Autowired
	public StudentRepository studentRepository;

	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/all")
	public List<Student> getAllStudent() {
		
		return studentRepository.findAll();
	
	}	
	
	@GetMapping("/find/{id}")
	public java.util.Optional<Student> getStudent(@PathVariable("id") String id) {
		
		return studentRepository.findById(id);
	
	}
	
	@PostMapping("/create")
	public String createStudent(@RequestBody Student student) {
		Student insertedStudent = studentRepository.insert(student);
		return "student created " + insertedStudent.getName();
	}
	
	
	@PutMapping("/update/{id}")
	public String updateStudent(@PathVariable("id") String id, @RequestBody Student student) {
	  java.util.Optional<Student> rt = studentRepository.findById(id);

	  if (rt.isPresent()) {
		  Student st = rt.get();
	    st.setName(student.getName());
	   st.setAge(student.getAge());
	  st.setGrade(student.getGrade());
	   student = studentRepository.save(st);
	    return "Successful" +" "+ student.getName()+" "+student.getAge()+" "+student.getGrade() ;
	  } else {
	   return "Unsuccessful";
	  }
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") String id) {
	  try {
		  studentRepository.deleteById(id);
		  return "Deleted sucessfully" ;
		  
	  } catch (Exception e) {
	    return "Unsucessful";
	  }
	}

	@DeleteMapping("/delete")
	public String deleteAllTutorials() {
	  try {
		  studentRepository.deleteAll();
	    return "Deleted sucessfully";
	  } catch (Exception e) {
	    return "Unsucessful";
	  }
	}
}
