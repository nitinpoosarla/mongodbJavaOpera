package com.javainuse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.javainuse.bean.User;

@Service
public class KafkaSender {
	
	
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	String kafkaTopic = "javainuse-topic";
	
	public void send(String data) {
	    
	    kafkaTemplate.send(kafkaTopic, data);
	    
	}
	
public void send1(User user) {
	  String x=  user.toString();
	    kafkaTemplate.send(kafkaTopic, x);
	    
	}
}