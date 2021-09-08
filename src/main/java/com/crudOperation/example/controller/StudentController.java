package com.crudOperation.example.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudOperation.example.DTO.StudentDto;
import com.crudOperation.example.entity.BaseResponse;
import com.crudOperation.example.entity.Student;
import com.crudOperation.example.entity.Subject;
import com.crudOperation.example.service.StudentService;



@RestController
@RequestMapping("/one")
public class StudentController {
//auto wired to inject from service 	
	@Autowired
	private StudentService studentService;

	
//post method
	@PostMapping("/post")
	public BaseResponse addStudent(@RequestBody StudentDto studentDto) {
		return studentService.addStudent(studentDto);
	}
//	@PostMapping("/addList")
//	public List<Student> saveStudent(@Valid @RequestBody List<Student> student){
//		return studentService.saveAllDetails(student);
//	}
	
	
	
//read method	
	@GetMapping("/get")
	public List<Subject> getAllDetails(){
		return studentService.listAllDetails();
	}
//read method by ID
	@GetMapping("/getById/{id}")
	public Student getDetailsByID(@PathVariable int id){
		return studentService.getStudentDetailsByID(id);
	}
	
	
	
//update method
	@PutMapping("/update") 
	public BaseResponse updateStudent(@RequestBody StudentDto studentDto) {
		return studentService.updateStudentDetails(studentDto);
	}
	
	
//delete method
	@DeleteMapping("/delete/{id}")
	public BaseResponse deleteStudent(@PathVariable int id){
		return studentService.deleteDetailsById(id);
	}
	
	 @DeleteMapping("/deletall")
	    public BaseResponse delete( ){
	        return studentService.deleteAll();
	    }
}
