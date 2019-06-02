package exort.se418.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import exort.se418.service.HelloService;

@RestController
public class HelloController{
	private Logger logger = LoggerFactory.getLogger(HelloController.class);

	@Autowired
	private HelloService helloService;

	@GetMapping("/hello")
	public String hello(){
		logger.info("say hello");
		return "hello";
	}
}

