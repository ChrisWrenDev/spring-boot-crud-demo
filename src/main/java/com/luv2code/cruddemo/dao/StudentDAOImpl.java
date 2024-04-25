package com.luv2code.cruddemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
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
}
