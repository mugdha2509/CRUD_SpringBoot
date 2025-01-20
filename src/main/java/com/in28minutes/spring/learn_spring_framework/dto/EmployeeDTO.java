//package com.in28minutes.spring.learn_spring_framework.dto;
//
//import java.time.LocalDate;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
////@Data automatically defines getter and setter functions using lombok dependency in pom.xml
////@AllArgsConstructor will build constructor for all the fields as arg automatically, can use @NoArgsConstructor for the opposite 
//
//@Data
//@AllArgsConstructor 
//@NoArgsConstructor
//public class EmployeeDTO {
//	
//	public EmployeeDTO(String string, long l, LocalDate of, boolean b) {
//		// TODO Auto-generated constructor stub
//	}
//	private String name;
//	private Long ID;
//	private LocalDate dateOfJoining;
//	private boolean isActive;
//	
////	// constructor for all the private fields // for initialization
////	public EmployeeDTO(String name, Long iD, LocalDate dateOfJoining, boolean isActive) {
////		super();
////		this.name = name;
////		ID = iD;
////		this.dateOfJoining = dateOfJoining;
////		this.isActive = isActive;
////	}
////	
////	//since the variables are private we need getter and setter function for these variables for which we have command of ( Alt + Shift + S) where we can click generate getters and setters )
////	public String getName() {
////		return name;
////	}
////	public void setName(String name) {
////		this.name = name;
////	}
////	public Long getID() {
////		return ID;
////	}
////	public void setID(Long iD) {
////		ID = iD;
////	}
////	public LocalDate getDateOfJoining() {
////		return dateOfJoining;
////	}
////	public void setDateOfJoining(LocalDate dateOfJoining) {
////		this.dateOfJoining = dateOfJoining;
////	}
////	public boolean isActive() {
////		return isActive;
////	}
////	public void setActive(boolean isActive) {
////		this.isActive = isActive;
////	}
//	
//}

package com.in28minutes.spring.learn_spring_framework.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data automatically defines getter and setter functions using lombok dependency in pom.xml
//@AllArgsConstructor will build constructor for all the fields as arg automatically, can use @NoArgsConstructor for the opposite 


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
	
//	public EmployeeDTO(String name, Long iD, LocalDate dateOfJoining, boolean isActive) {
//		
//		this.name = name;
//		ID = iD;
//		this.dateOfJoining = dateOfJoining;
//		this.isActive = isActive;
//	}
	

	private String name;
    private Long ID;
    private LocalDate dateOfJoining;
    

    private boolean isActive;

	
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


}

