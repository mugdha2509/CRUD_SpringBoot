package com.in28minutes.spring.learn_spring_framework.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {

//	public EmployeeEntity(String name, Long iD, LocalDate dateOfJoining, boolean isActive) {
//		
//		this.name = name;
//		ID = iD;
//		this.dateOfJoining = dateOfJoining;
//		this.isActive = isActive;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	private String name;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// IT Will generate automatically the ID
    private Long ID;
    private LocalDate dateOfJoining;
    private boolean isActive;
    
}
