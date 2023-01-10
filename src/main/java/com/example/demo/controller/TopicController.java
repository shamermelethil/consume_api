package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	@Autowired
	TopicService topicService;
	
	@RequestMapping(value ="/hello", method = RequestMethod.GET)
	public ResponseEntity<String > sayHello(){
		
		return new ResponseEntity<String>("hello",HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value ="/list", method = RequestMethod.GET)
	public ResponseEntity<List<String> > list(){
		List<String> l = new ArrayList<String>();
		l.add("Apple");
		l.add("Blackberry");
		l.add("Android");
		l.add("BlueBerry");
		
		l.add("banana");
		l.add("orange");
		l.add("Dragon fruit");
		l.add("AAAAA");



		return new ResponseEntity<List<String>>(l,HttpStatus.OK);
		
	}
	
	
	
	
	
	@RequestMapping(value ="/topics", method = RequestMethod.GET)
	public ResponseEntity< List<Topic >> topics(){
		
				return new  ResponseEntity< List<Topic >>(topicService.getAllTopics(),HttpStatus.OK);
				
	}
	

	@RequestMapping(value ="/topics/{id}", method = RequestMethod.GET)
	public ResponseEntity<Topic > topics(@PathVariable String id){
		
				return new  ResponseEntity<Topic >(topicService.getTopic(id),HttpStatus.OK);
				
	}
	
	
	
	@RequestMapping(value ="/topics", method = RequestMethod.POST)
	public ResponseEntity<String > topics(@RequestBody Topic topic){
		topicService.addTopic(topic);
				return new  ResponseEntity<String >("Success",HttpStatus.OK);
				
	}
	
	
	

	@RequestMapping(value ="/topics/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String > updateTopic(@RequestBody Topic topic,@PathVariable String id){
		topicService.updateTopic(id, topic);
				return new  ResponseEntity<String >("Success",HttpStatus.OK);
				
	}
	
	
	@RequestMapping(value ="/topics/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String > deleteTopic(@PathVariable String id){
		topicService.removeTopic(id);				return new  ResponseEntity<String >("Success",HttpStatus.OK);
				
	}



	
	

}
