package exort.se418.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import exort.se418.service.HelloService;
import exort.se418.service.LadderService;

@RestController
public class HelloController{
	@Autowired
	private HelloService helloService;
	@Autowired
	private LadderService ladderService;

	@GetMapping("/")
	public String homepage(){
		return "Home Page";
	}

	@GetMapping("/hello/{who}")
	public String hello(@PathVariable("who") String who){
		return "hello "+who;
	}

	@GetMapping("/sayhello/{who}")
	public String sayHello(@PathVariable("who") String who){
		return "say "+helloService.hello(who);
	}

	@GetMapping("/ladder/{begin}/{end}")
	public String generateLadder(@PathVariable("begin") String begin, @PathVariable("end") String end){
		return ladderService.generateLadder(begin,end);
	}

	@GetMapping("/github")
	public String ladderDogToCat(){
		return helloService.rediectToGithubPage();
	}
}

