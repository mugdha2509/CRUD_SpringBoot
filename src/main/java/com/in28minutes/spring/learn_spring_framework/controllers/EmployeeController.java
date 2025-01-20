package com.in28minutes.spring.learn_spring_framework.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.spring.learn_spring_framework.dto.EmployeeDTO;
import com.in28minutes.spring.learn_spring_framework.services.EmployeeService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
	//controller => service => repository
	
	//controller needs service to be injected
	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	


//    @GetMapping(path = "/employees/{id}")
//    public EmployeeDTO getEmployees(@PathVariable("id") Long employeeId) {
//        return new EmployeeDTO("Alice", employeeId , LocalDate.of(2022, 1, 1), true);
//    }
	
// with the help of service now 
  @GetMapping(path = "/{id}")
  public EmployeeDTO getEmployeeById(@PathVariable("id") Long employeeId) {
      return employeeService.getEmployeeById(employeeId);
  }
  
  @GetMapping
  public List<EmployeeDTO> getAllEmployees(){
	  return employeeService.getAllEmployees();
  }
  
  //@PostMapping(path = "/employees") // but now we put requestmapping at top so we dont need to write /employees in the path now 
  @PostMapping()
  public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employeeDTO) {
	  return employeeService.createNewEmployee(employeeDTO);
  }
  
  @DeleteMapping("/{id}")
  public void deleteEmployeeById(@PathVariable("id") Long employeeId) {
      employeeService.deleteEmployeeById(employeeId);
  }

    
//    // this is how link would go http://localhost:8080/employees?sortBy=Mugdha&limit=50 , here sortBy and limit are optional 
//    @GetMapping(path = "/employees")
//    public String getData(@PathParam("sortBy") String sortBy, @PathParam("limit") Integer limit ) {
//    	return "Hello" + " " + sortBy + " " + limit;
//    } 
}
