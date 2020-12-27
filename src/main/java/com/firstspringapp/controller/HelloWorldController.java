package com.firstspringapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.firstspringapp.model.User;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {
	// curl -X GET "http://localhost:8080/hello" -w "\n"
	@RequestMapping(value = { "", "/", "home" })
	public String sayHello() {
		return "Hello World!!! Welcome to home page.";
	}

	// curl -X GET "http://localhost:8080/hello/query/?name=Pallavi" -w "\n"
	@RequestMapping(value = { "/query" }, method = RequestMethod.GET)
	public String sayHello(@RequestParam(value = "name") String name) {
		return "Hello " + name + "! Inside GET method query.";
	}

	// curl -X GET "http://localhost:8080/hello/param/Pallavi" -w "\n"
	@GetMapping("/param/{name}")
	public String sayHelloParam(@PathVariable String name) {
		return "Hello " + name + "! Inside get-mapping.";
	}

	// curl -X POST -H "Content-Type: application/json" -d '{"firstName": "Pallavi", "lastName": "Kyama"}' "http://localhost:8080/hello/post" -w "\n"
	@PostMapping("/post")
	public String sayHello(@RequestBody User user) {
		return "Hello " + user.getFirstName() + " " + user.getLastName() + "! Inside post-mapping.";
	}
	
	// curl -X PUT "http://localhost:8080/hello/put/Pallavi?lastName=Kyama" -w "\n"
	@PutMapping("/put/{firstName}")
	public String sayHello(@PathVariable String firstName,@RequestParam(value = "lastName") String lastName) {
		return "Hello " + firstName + " " + lastName + "! Inside put-mapping.";
	}
}
