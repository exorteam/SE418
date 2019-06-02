package exort.se418.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import exort.se418.service.HelloService;

@RestController
public class HelloController{
	@Autowired
	private HelloService helloService;

	@GetMapping("/hello/{who}")
	public String hello(@PathVariable("who") String who){
		return "hello "+who;
	}

	@GetMapping("/sayhello/{who}")
	public String sayHello(@PathVariable("who") String who){
		return "say "+helloService.hello(who);
	}
}

