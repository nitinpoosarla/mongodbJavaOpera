package com.assignment.springboot.mongo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.assignment.springboot.mongo.model.Employee;

public interface Employeedao  extends MongoRepository<Employee, Integer>{

}
