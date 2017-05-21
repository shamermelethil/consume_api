package com.example.demo;

import java.util.ArrayList;

import org.apache.derby.tools.sysinfo;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import java.util.*;
//http://www.concretepage.com/spring/spring-mvc/spring-rest-client-resttemplate-consume-restful-web-service-example-xml-json#delete
import com.example.demo.controller.Topic;
public class Consume {
	
	public static String baseURL="http://localhost:8081";
    static RestTemplate restTemplate = new RestTemplate();


	public static void main(String[] args) {
		//getMethodTest();
		listTest();
		//topics();
		//getaTopic();
		//listTest();
		//createTopic();
		//put();
		//delete();
	}
	
	public static  void getMethodTest()
	{
		// TODO Auto-generated method stub
        String content = restTemplate.getForObject(baseURL+"/hello", String.class);
        System.out.println("-------------");
        
        ResponseEntity<String > s = restTemplate.getForEntity(baseURL+"/hello", String.class);
        System.out.println(s.getBody());
        System.out.println(s.getStatusCodeValue());
        System.out.println(s.getHeaders());
        System.out.println(s.getStatusCode());

	}
	
	public static void listTest(){
        //List<T> list = restTemplate.getForObject(baseURL+"/topics", List<T>.class);
        //ParameterizedTypeReference<List<String>> myBean = new ParameterizedTypeReference<List<String>>() {};
        //ResponseEntity<List<String>> response = restTemplate.exchange("http://example.com",HttpMethod.GET, null, myBean);
		//List<String> l = 		restTemplate.exchange(baseURL+"/topics", HttpMethod.GET, null, List<String>().class);

       // List<String> list = restTemplate.getForObject(baseURL+"/list", List.class);
		ResponseEntity<List<String>> list = restTemplate.exchange(baseURL+"/list", HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>(){});
		System.out.println(list.getBody().toString());
       // System.out.println(list);
		//ResponseEntity<? extends ArrayList<String>> responseEntity = restTemplate.getForEntity(baseURL+"/list", (Class<? extends ArrayList<String>>)ArrayList.class);
		//System.out.println(responseEntity);

		//System.out.println(responseEntity.getBody());

       
	}
	
	public static void  topics(){
		 ResponseEntity<List<Topic>> rateResponse =
	                restTemplate.exchange(baseURL+"/topics",
	                            HttpMethod.GET, null, new ParameterizedTypeReference<List<Topic>>() {
	                    });
	        List<Topic> rates = rateResponse.getBody();
	        for (Topic t:rates){
	        	System.out.println(t.getName());
	        }
	}
	public static void getaTopic(){
		
		
        Map<String,String > map = new HashMap<String,String>();
        map.put("id", "Java");
        
        ResponseEntity<Topic > topic = restTemplate.getForEntity(baseURL+"/topics/{id}", Topic.class,map);
        System.out.println(topic.getBody().getDescription());
       // Topic topic = restTemplate.getForObject(baseURL+"/topics/{id}", Topic.class,"Java");
        //System.out.println(topic.getDescription());

        

		
	}
	
	public static void createTopic(){
		Topic t = new Topic("Angular","Angular JS","Angular desc");
		String s=restTemplate.postForObject(baseURL+"/topics", t, String.class);
		System.out.println(s);
		
		//With JSON Paylod 
		
		String requestJson = "{\"id\":\"Cassandra\",\"name\":\"Cassandra\",\"description\":\"Cassandra\"}";
		
		HttpHeaders h = new HttpHeaders();
		//h.add(headerName, headerValue);
		h.setContentType(MediaType.APPLICATION_JSON);
		
	HttpEntity<String > e= new HttpEntity<String>(requestJson,h);
	String msg=restTemplate.postForObject(baseURL+"/topics", e, String.class);
	System.out.println(msg);

	ArrayList<String> w = new ArrayList<String>();
	MultiValueMap<String,String> m = new LinkedMultiValueMap<String,String>();
	m.put("a", w);
	Map<String,List<String>> k;

		
	}
	
	public static void put(){
String requestJson = "{\"id\":\"Cassandra\",\"name\":\"Cassandra updted\",\"description\":\"Cassandra updated\"}";
		
		HttpHeaders h = new HttpHeaders();
		//h.add(headerName, headerValue);
		h.setContentType(MediaType.APPLICATION_JSON);
		
	HttpEntity<String > e= new HttpEntity<String>(requestJson,h);
	//String msg=restTemplate.postForObject(baseURL+"/topics", e, String.class);
	restTemplate.put(baseURL+"/topics/{id}", e,"Cassandra");


	}

	public static void delete(){
String requestJson = "{\"id\":\"Cassandra\",\"name\":\"Cassandra updted\",\"description\":\"Cassandra updated\"}";
		
		HttpHeaders h = new HttpHeaders();
		//h.add(headerName, headerValue);
		h.setContentType(MediaType.APPLICATION_JSON);
		
	HttpEntity<String > e= new HttpEntity<String>(requestJson,h);
	//String msg=restTemplate.postForObject(baseURL+"/topics", e, String.class);
	//restTemplate.put(, e,"Cassandra");
	restTemplate.delete(baseURL+"/topics/{id}", "Cassandra");
	


	}
}
