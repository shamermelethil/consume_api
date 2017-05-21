package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("Java","core java ","jav desc"),
			new Topic("Spring","spring mvc"," spring desc"),
			new Topic("Python","pythn flask","python dsc")
			));
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	public Topic getTopic(String id){
		return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic){
		topics.add(topic);
		System.out.println(topics);
	}
	
	public void updateTopic(String id,Topic topic){
		for (int i = 0; i < topics.size(); i++){
			Topic t = topics.get(i);
			if (t.getId().equals(id)){
				topics.set(i, topic)
				;
				return;
			}
		}
	}
	
	public void removeTopic(String id){
		topics.removeIf(t->t.getId().equals(id));
	}
}
