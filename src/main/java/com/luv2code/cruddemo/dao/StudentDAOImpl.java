package com.luv2code.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {
   private EntityManager entityManager;
  
  @Autowired
  public StudentDAOImpl(EntityManager theEntityManager){
    entityManager = theEntityManager;
  }
  
  @Override
  @Transactional
  public void save(Student theStudent){
    entityManager.persist(theStudent);
  }
  
  @Override
  public Student findById(Integer id){
    return entityManager.find(Student.class, id);
  }

  @Override
  public List<Student> findAll(){
    TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
    return theQuery.getResultList();
  }
}
