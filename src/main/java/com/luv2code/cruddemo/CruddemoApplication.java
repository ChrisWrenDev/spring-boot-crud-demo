package com.luv2code.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	// Inject the student DAO
  @Bean
  public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
    return runner -> {
      createStudent(studentDAO);
    };
  }
  // create and save student to database
  private void createStudent(StudentDAO studentDAO){
    // create the student object
    System.out.println("Creating new student object...");
    Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");
    
    // save the student object
    System.out.println("Saving the student...");
    studentDAO.save(tempStudent);
    
    // display id of the saved student
    System.out.println("Saved student. Generated id: " + tempStudent.getId());
  }
}