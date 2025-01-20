//package com.in28minutes.spring.learn_spring_framework.services;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Service;
//
//import com.in28minutes.spring.learn_spring_framework.dto.EmployeeDTO;
//import com.in28minutes.spring.learn_spring_framework.entities.EmployeeEntity;
//import com.in28minutes.spring.learn_spring_framework.repositories.EmployeeRepository;
//
//@Service
//public class EmployeeService {
//	
//	//injecting dependency of EmployeeRepository // will  inject in constructor directly 
//	final EmployeeRepository employeeRepository; // we make it final so cant be changes
//	final ModelMapper modelMapper;
//
//	public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
//		this.employeeRepository = employeeRepository;
//		this.modelMapper = modelMapper;
//		
//	}
//	
////	public EmployeeDTO getEmployeeById(Long id) {
////	    EmployeeEntity employeeEntity = employeeRepository.findById(id)
////	        .orElseThrow(() -> new RuntimeException("Employee not found for ID: " + id));
////	    return new EmployeeDTO(
////	        employeeEntity.getName(),
////	        employeeEntity.getID(),
////	        employeeEntity.getDateOfJoining(),
////	        employeeEntity.isActive()
////	    ); // converted entity to DTO, to avoid this we can use dependency of modelmapper
////	    
////	    
////	}
//	
//	public EmployeeDTO getEmployeeById(Long id) {
//		@SuppressWarnings("deprecation")
//		EmployeeEntity employeeEntity = employeeRepository.getById(id);
//		return modelMapper.map(employeeEntity, EmployeeDTO.class);
//		// converted entity to DTO using modelMapper bean
//	}
//	
//	public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
//		EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
//		return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class); // converted to employeeDTO class as EmployeeDTO type is returned in the function 
//		// converted entity to DTO using modelMapper bean
//	}
//	
//	
//
//	
//
//}
package com.in28minutes.spring.learn_spring_framework.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.in28minutes.spring.learn_spring_framework.dto.EmployeeDTO;
import com.in28minutes.spring.learn_spring_framework.entities.EmployeeEntity;
import com.in28minutes.spring.learn_spring_framework.repositories.EmployeeRepository;

@Service
public class EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long id) {
        return employeeRepository.findById(id)
            .map(entity -> modelMapper.map(entity, EmployeeDTO.class))
            .orElseThrow(() -> {
                logger.error("Employee not found for ID: {}", id);
                return new RuntimeException("Employee not found for ID: " + id);
            });
    }
    
    public List<EmployeeDTO> getAllEmployees(){
    	return employeeRepository
    			.findAll()
    			.stream() // instead of for loop we can use .stream()
    			.map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class)) // converted them entity to DTO 
    			.collect(Collectors.toList()); // gave them in a list 
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        EmployeeEntity savedEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEntity, EmployeeDTO.class);
    }
    
    public void deleteEmployeeById(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Employee not found for ID: " + id);
        }
        employeeRepository.deleteById(id);
    }

}
