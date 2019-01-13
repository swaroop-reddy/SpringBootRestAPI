package com.swaroop.SpringBootRestAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.swaroop.SpringBootRestAPI.model.Employee;
import com.swaroop.SpringBootRestAPI.repository.EmployeeRepository;

@RestController
@RequestMapping(value="/empl")
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepository;
	
	@GetMapping(value="/getAllEmpl")
	public Iterable<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	@PostMapping(value="/createEmpl")
	public void createEmployee(@RequestBody Employee employee ){
		employee.getAddress().setEmpl(employee);
		employeeRepository.save(employee);
	}
	@DeleteMapping(value="/deleteEmplById/{id}")
	public void deleteEmployeeById(@PathVariable Long id){
		employeeRepository.deleteById(id);
	}
	@GetMapping(value="/getByFirstName/{firstName}")
	public Iterable<Employee> getByFirstName(@PathVariable String firstName){
		return employeeRepository.getByFirstName(firstName);
	}
	
}
