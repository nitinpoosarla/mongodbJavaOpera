package com.assignment.springboot.mongo.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.springboot.mongo.dao.Employeedao;
import com.assignment.springboot.mongo.model.Employee;

@Service
public class Employeeserviceimpl  
{
	@Autowired
	Employeedao empdao;
	
		
	public void createemployee(List<Employee> emp)
	{
		empdao.saveAll(emp);
	}

	public Collection<Employee> getAllEmployees()
	{
		return empdao.findAll();
	}
	
	public Optional<Employee> findEmployeeById(int id)
	{
		return empdao.findById(id);
		
	}
	
	public void updateEmployee(Employee emp)
	{
		empdao.save(emp);
	}
	
	public void deleteEmployeeById(int id) {
		empdao.deleteById(id);
    }
	public void deleteAllEmployees() {
		empdao.deleteAll();
    }
}
