package exort.se418.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import exort.se418.service.FeignService;

@RestController
public class FeignController{
	@Autowired
	private FeignService service;

	@GetMapping("/")
	public String homepage(){
		return "Home Page";
	}

	@GetMapping("/ladder")
	public String generateLadder(@RequestParam String start,@RequestParam String end){
		return service.generateLadder(start,end);
	}
}

