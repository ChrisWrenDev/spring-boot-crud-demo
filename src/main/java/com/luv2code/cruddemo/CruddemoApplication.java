package com.luv2code.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

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
      // createStudent(studentDAO);

      // createMultipleStudents(studentDAO);

      // readStudent(studentDAO);

      queryForStudents(studentDAO);
    };
  }

  private void createMultipleStudents(StudentDAO studentDAO){
    // create multiple students
    System.out.println("Creating 3 student objects...");
    Student tempStudent1 = new Student("John", "Smith", "john@luv2code.com");
    Student tempStudent2 = new Student("Terry", "Crews", "terry@luv2code.com");
    Student tempStudent3 = new Student("Adam", "Sandler", "adam@luv2code.com");

    // save the student objects
    System.out.println("Saving the student...");
    studentDAO.save(tempStudent1);
    studentDAO.save(tempStudent2);
    studentDAO.save(tempStudent3);
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

  private void readStudent(StudentDAO studentDAO){
  //create a student Object
  System.out.println("Creating new student object...");
  Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");
  // save the student object
  System.out.println("Saving the student...");
  studentDAO.save(tempStudent);
  // display id of the saved student
  System.out.println("Saved student. Generated id: " + tempStudent.getId());
  // retrieve student based on the id: primary key
  System.out.println("\nRetrieving student with id: " + tempStudent.getId());
  Student myStudent = studentDAO.findById(tempStudent.getId());
  System.out.println("Found the student: " + myStudent);
  }

private void queryForStudents(StudentDAO studentDAO){
    // get list of students
    List<Student> theStudents = studentDAO.findAll();
    // display list of students
    for(Student tempStudent : theStudents){
      System.out.println(tempStudent);
    }
  }

  private void queryForStudentsByLastName(StudentDAO studentDAO){
    // get a list of students
    List<Student> theStudents = studentDAO.findByLastName("Duck");
    // display list of students
    for(Student tempStudent : theStudents){
      System.out.println(tempStudent);
    }
  }
}
