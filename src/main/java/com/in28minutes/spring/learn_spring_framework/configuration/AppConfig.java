package com.in28minutes.spring.learn_spring_framework.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.spring.learn_spring_framework.DB;
import com.in28minutes.spring.learn_spring_framework.DevDB;
import com.in28minutes.spring.learn_spring_framework.ProdDB;

@Configuration
//Configuration means we can find many beans inside this file 
public class AppConfig {

	// here we can supply objects 
	
//	@Bean
//	// a bean that will bring prod objects 
//	public DB getBean() {
//		return new ProdDB();// makaes singleton project 
//	}
	
	@Bean
	@ConditionalOnProperty(name = "project.mode", havingValue = "development")
	public DB getDevDBBean() {
		return new DevDB();
	}
	
	@Bean
	@ConditionalOnProperty(name = "project.mode", havingValue = "production")
	public DB getProdDBBean() {
		return new ProdDB();
	}
	
	//creating bean of model mapper when uploaded its dependency 
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
