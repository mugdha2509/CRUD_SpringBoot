package com.in28minutes.spring.learn_spring_framework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnSpringFrameworkApplication implements CommandLineRunner {

//	ProdDB prodDB;
	
	@Autowired
	// @autowired connects db object to beans /// DEPENDENCY INJECTION 
	DB db;
//	defining outside function so that we can access the object anywhere in the class
	public static void main(String[] args) {
		SpringApplication.run(LearnSpringFrameworkApplication.class, args);
		
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		db = new ProdDB(); //now with the help of db from DB interface we can use ProdDB but it it still tightly coupled because if i want dev data then i have to replace here with DevDb()
		//therefore we use dependency injection without using a "new" keyword
		// we will use bean which will supply that object everywhere
		System.out.println(db.getData()); // now it gives error this.db is null we didnt inject the dependency yet 
		
		
	}

}
