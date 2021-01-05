package com.firstspringapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.firstspringapp.model.Greeting;
import com.firstspringapp.model.User;
import com.firstspringapp.service.IGreetingService;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

	@Autowired
	private IGreetingService greetingService;

	// curl -X GET "http://localhost:8080/greeting" -w "\n"
	@GetMapping(value = { "", "/", "home" })
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		User user = new User();
		user.setFirstName(name);
		return greetingService.addGreeting(user);
	}

}
