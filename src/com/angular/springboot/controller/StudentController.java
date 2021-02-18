package com.angular.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angular.springboot.entity.Student;
import com.angular.springboot.service.StudentService;

@RestController
@CrossOrigin(origins="http://localhost:4200")  
@RequestMapping(value="/api")  
public class StudentController {  
      
    @Autowired  
    private StudentService studentservice;  
    
    @Autowired
    private HttpServletRequest request;
      
    @PostMapping("/save")  
    public boolean saveStudent(@RequestBody Student student) {  
    	System.out.println("Inside Save Student");
    	System.out.println("Student Name-"+student.getStudentName());
    	System.out.println("Student Email-"+student.getStudentEmail());
    	System.out.println("Student Branch-"+student.getStudentBranch());
    	System.out.println("Http Headers Authorization: "+request.getHeader("Authorization"));
    	System.out.println("Student ID Parameter: "+request.getParameter("studentID"));
        return studentservice.saveStudent(student);  
          
    }  
      
    @GetMapping("/list")  
    public List<Student> allstudents() {  
    	System.out.println("Before Getting students list.....");
         return studentservice.getStudents();  
          
    }  
      
    @DeleteMapping("/delete/{id}")  
    public boolean deleteStudent(@PathVariable("id") int id) {
    	System.out.println("Delete Student id-"+id);
    	Student student = new Student();
        student.setStudentId(id);  
        return studentservice.deleteStudent(student);  
    }  
  
    @GetMapping("student/{id}")  
    public List<Student> allStudentByID(@PathVariable("id") int id,Student student) {  
         student.setStudentId(id);  
         return studentservice.getStudentByID(student);  
          
    }
    
    @GetMapping("getStudent/{id}")  
    public Student getStudent(@PathVariable("id") int id) {  
    	Student student = new Student();
    	
         student.setStudentId(id);
         student.setStudentName("Saravanan");
         student.setStudentEmail("saran.kathir2005@gmail.com");
         student.setStudentBranch("Chennai");
        // studentservice.saveStudent(student);  
        // return studentservice.getStudentByID(student).get(0);
         return student;
          
    }
      
    @PostMapping("update-student/{id}")  
    public boolean updateStudent(@RequestBody Student student,@PathVariable("id") int id) {  
        student.setStudentId(id);  
        return studentservice.updateStudent(student);  
    }  
    
}  