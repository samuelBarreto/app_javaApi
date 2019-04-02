package com.example.simplerestapis.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.simplerestapis.models.PostRequest;
import com.example.simplerestapis.models.PostResponse;
import com.example.simplerestapis.models.SampleResponse;
import com.example.simplerestapis.models.ValueResponse;

@RestController
public class WebController {

	 private final AtomicInteger counter = new AtomicInteger();

    @CrossOrigin(origins = "http://localhost:9000")
    @GetMapping("/value")
    public ValueResponse value() {
        System.out.println("==== in greeting ====");
        return new ValueResponse(counter.incrementAndGet());
    }

    @GetMapping("/value-javaconfig")
    public ValueResponse valueWithJavaconfig() {
        System.out.println("==== in greeting ====");
        return new ValueResponse(counter.incrementAndGet());
    }


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
	
}
