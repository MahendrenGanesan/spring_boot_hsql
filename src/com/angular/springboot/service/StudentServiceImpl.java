package com.angular.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angular.springboot.entity.Student;
import com.angular.springboot.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public boolean saveStudent(Student student) {
		
		studentRepository.save(student);
		
		return true;
	}

	@Override
	public List<Student> getStudents() {
		
		List<Student> students = (List<Student>) studentRepository.findAll();
		System.out.println("Students List - "+students.get(0).getStudentName());
		return students;
	}

	@Override
	public boolean deleteStudent(Student student) {
		
		studentRepository.delete(student);
		
		return true;
	}

	@Override
	public List<Student> getStudentByID(Student student) {
		List<Student> students = new ArrayList<>();
		student = studentRepository.findById(student.getStudentId()).get();
		students.add(student);
		return students;
	}

	@Override
	public boolean updateStudent(Student student) {
		studentRepository.save(student);
		return true;
	}

}
