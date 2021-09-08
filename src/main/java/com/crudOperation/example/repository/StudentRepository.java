package com.crudOperation.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudOperation.example.entity.Student;
import com.crudOperation.example.entity.Subject;



@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	//List<Subject> findByStudentId(int id);
}

