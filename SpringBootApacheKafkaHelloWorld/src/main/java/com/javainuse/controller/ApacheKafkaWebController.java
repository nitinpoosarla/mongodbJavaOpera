package com.javainuse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.javainuse.bean.User;
import com.javainuse.service.KafkaSender;

@RestController
@RequestMapping(value = "/javainuse-kafka/")
public class ApacheKafkaWebController {

	@Autowired
	KafkaSender kafkaSender;
	
	
	
	@GetMapping(value = "/producer")
	public String producer(@RequestParam("message") String message) {
		kafkaSender.send(message);
		return "Message sent to the Kafka Topic java_in_use_topic Successfully";
	}
	
	@PostMapping(value="/create",headers="Accept=application/json")
	 public String createUser(@RequestBody User user){
	     System.out.println("Creating User "+user.getFname());
	     System.out.println("Creating User "+user.getLname());
	    // userService.createUser(user);
	   //  HttpHeaders headers = new HttpHeaders();
	    // headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
	     kafkaSender.send1(user);
	     return "jsonmessg send";
	 }
	
	

	
	
}

