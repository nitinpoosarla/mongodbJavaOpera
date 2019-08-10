package com.assignment.springboot.mongo.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.springboot.mongo.model.Employee;
import com.assignment.springboot.mongo.service.Employeeserviceimpl;

@RestController
@RequestMapping(value= "/api/mongo/emp")
public class Employeecontroller {

	@Autowired
    Employeeserviceimpl serv;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@PostMapping("/create")
	public String create(@RequestBody List<Employee> emp)
	{
		logger.debug("saving employee");
		serv.createemployee(emp);
		return "employes created succesfully";
		
	}

	@GetMapping("/getall")
	public Collection<Employee> getAll()
	{
		logger.debug("gett all employee");
		return serv.getAllEmployees();
	}
	
	@GetMapping("/getbyid/{employee-id}")
	public Optional<Employee> getById(@PathVariable(value="employee-id") int id)
	{
		logger.debug("getbyId"+id);
		return serv.findEmployeeById(id);
	}
	
	@PutMapping("/update/{employee-id}")
	public String update(@PathVariable(value="employee-id") int id,@RequestBody Employee emp)
	{
		logger.debug("updating employee"+id);
		serv.updateEmployee(emp);
		return "employee updated"+id;
	}
	
	@DeleteMapping("/delete/{employee-id}")
	public String delete(@PathVariable(value="employee-id") int id)
	{
		logger.debug("deleting employee"+id);
		serv.deleteEmployeeById(id);
		return "delete successfull"+id;	
	}
	
	@DeleteMapping("/deleteall")
	public String deleteAll()
	{
		logger.debug("deleting all");
		serv.deleteAllEmployees();
		return "deleteing all";
	}
	
}
