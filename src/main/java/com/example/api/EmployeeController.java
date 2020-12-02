package com.example.api;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@GetMapping("/static")
	public String getName() {
		return "Employee Working";
		
	}
	
//PathVariable
	@GetMapping(path="/dynamic/{name}",produces =MediaType.APPLICATION_XML_VALUE)
	public String getNumber(@PathVariable String name) {
		return name;
		
	}
//RequestParam
	@GetMapping("/dynamic")
	public int getNumberReqParam(@RequestParam(value="empid",defaultValue ="123") int id) {
		return id;
		
	}
//produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}
	@GetMapping(path="/employeeobj/{name}",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Employee> getEmpObj(@PathVariable String name) {
		Employee emp= new Employee();
		emp.setName(name);
		emp.setEmail("madhus@gmail.com");
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		
	}
	
	
	@PostMapping(path="/employeeobj",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Employee> createEmpObj(@RequestBody Employee emprec) {
		Employee emp= new Employee();
		emp.setName(emprec.getName());
		emp.setEmail(emprec.getEmail());
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		
	}
}
