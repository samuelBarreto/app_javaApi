package com.example.simplerestapis.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.simplerestapis.models.PostRequest;
import com.example.simplerestapis.models.PostResponse;
import com.example.simplerestapis.models.SampleResponse;
import com.example.simplerestapis.models.ValueResponse;

@RestController
public class WebController {

	@CrossOrigin(origins = "http://app-javaapi.herokuapp.com/sample")
	@RequestMapping("/sample")
	public SampleResponse Sample(@RequestParam(value = "name",
	defaultValue = "Robot") String name) {
		SampleResponse response = new SampleResponse();
		response.setId(1);
		response.setMessage("Your name is "+name);
		return response;

	}
	
	@CrossOrigin(origins = "http://app-javaapi.herokuapp.com/test")
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public PostResponse Test(@RequestBody PostRequest inputPayload) {
		PostResponse response = new PostResponse();
		response.setId(inputPayload.getId()*100);
		response.setMessage("Hello " + inputPayload.getName());
		response.setExtra("Some text");
		return response;
	}
	
	@CrossOrigin(origins = "http://localhost:9000/")
	@RequestMapping("/value")
        public ValueResponse value() {
        return new ValueResponse();
    }
	
	@RequestMapping("/value-javaconfig")
        public ValueResponse valueWithJavaconfig() {
        return new ValueResponse();
    }
	
	
}
