package com.javahelps.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("JavaHelps");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
		create(1,"Zubeir",25);
		create(2,"Gambhir",27);
		create(3,"Tariq",22);
		
		ENTITY_MANAGER_FACTORY.close();
	}

	//Create a New Student 
	private static void create(int id, String name, int age) {
		
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		
		try {
			transaction = manager.getTransaction();
			
			transaction.begin();
			
			Student stud = new Student();
			stud.setId(id);
			stud.setName(name);
			stud.setAge(age);
			
			manager.persist(stud);
			
			transaction.commit();
		
		} catch(Exception e) {
		 
		 if(transaction != null) {
			 transaction.rollback();
		 }
		 e.printStackTrace();
	}finally {
		manager.close();
	}
}
	 public static List readAll() {
		 
		 List students = null;
		 
		 EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
			EntityTransaction transaction = null;
			
		try {	
           transaction = manager.getTransaction();
			
			transaction.begin();
			
			students = manager.createQuery("SELECT s FROM Student s",
					   Student.class).getResultList();
			
			transaction.commit();
			
		}catch(Exception e) {
			 
			 if(transaction != null) {
				 transaction.rollback();
			 }
			 e.printStackTrace();
		}finally {
			manager.close();
		}	
	 return students;
   }
}
