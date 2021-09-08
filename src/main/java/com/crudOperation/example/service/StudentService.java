package com.crudOperation.example.service;

import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.constraints.Null;

//import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudOperation.example.DTO.ListDto;
import com.crudOperation.example.DTO.StudentDto;
import com.crudOperation.example.DTO.SubjectDto;
import com.crudOperation.example.entity.BaseResponse;
import com.crudOperation.example.entity.Student;
import com.crudOperation.example.entity.Subject;
import com.crudOperation.example.repository.StudentRepository;
import com.crudOperation.example.repository.SubjectRepository;



@Service
@Transactional
public class StudentService {
//auto wired to inject	from repository
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private SubjectRepository subjectRepository;
//post method 	 
	
	public BaseResponse addStudent (StudentDto studentDto) {
		Student student = new Student();
		 BaseResponse baseResponse=new BaseResponse(); 
	        //List<Subject> subjectlist = new LinkedList<>();
	        student.setName(studentDto.getName());
	        student.setCity(studentDto.getCity());
	        studentRepository.save(student);
	        
	        studentDto.getSubjectDto().stream().forEachOrdered(subjectDto -> {

	        Subject subject = new Subject();
	        subject.setSubjectName(subjectDto.getSubjectName());
            subject.setStudent(student);
	       // subject.setSubjectName(studentDto.getSubjectName());
	        subjectRepository.save(subject);
	        });
	        
	        //baseResponse.setData(studentDto);
	        baseResponse.setStatusCode("200");
	        baseResponse.setStatusMsg("ID Created Successfully");
	        return baseResponse;
	}
	


	
//  public List<Student> saveAllDetails(List<Student> student) {
//	        return studentRepository.saveAll(student);
//	    }
	    
	  
//get method	 
	 public List<Subject> listAllDetails() {
	        return subjectRepository.findAll();	
	    }
//get by id  method	 
	 public Student getStudentDetailsByID(int id) {
		 return studentRepository.findById(id).orElse(null);
	 }
	    
//update method	 
	 public BaseResponse updateStudentDetails(StudentDto studentDto) {
	        BaseResponse baseResponse=new BaseResponse();
	    Student existstudent=studentRepository.findById(studentDto.getId()).orElse(null);
	    
	    existstudent.setName(studentDto.getName());
	    existstudent.setCity(studentDto.getCity());
	        studentRepository.save(existstudent);

	    studentDto.getSubjectDto().stream().forEachOrdered(subjectDto -> {
	    	Subject existsubject = subjectRepository.findById(subjectDto.getSubId()).orElse(null);
	    	existsubject.setSubjectName(subjectDto.getSubjectName());
	    	existsubject.setStudent(existstudent);
	        subjectRepository.save(existsubject);
	        });
	        
	        baseResponse.setStatusCode("200");
	        baseResponse.setStatusMsg("Updated Successfully");
	        return baseResponse;
   
	    }
//delete method	 
	 public BaseResponse deleteDetailsById(int id) {
		 BaseResponse baseResponse = new BaseResponse();
		  studentRepository.deleteById(id);
	      baseResponse.setData(id);
		  baseResponse.setStatusCode("200");
		  baseResponse.setStatusMsg("Details Deleted Succesfully");
		  return  baseResponse;
	 }


	 public BaseResponse deleteAll(){
	        BaseResponse baseResponse = new BaseResponse();
	        studentRepository.deleteAll();
	        subjectRepository.deleteAll();
	        baseResponse.setStatusCode("200");
	        baseResponse.setStatusMsg("success");
	        return baseResponse;
	
}
}