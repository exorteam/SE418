package exort.se418.service;

import org.springframework.cloud.openfeign.FeignClient;

import exort.se418.config.HelloClientConfiguration;
import feign.RequestLine;

@FeignClient(url="localhost:8080",name="hello-service",configuration = HelloClientConfiguration.class)
public interface HelloService{
	@RequestLine("GET /hello")
	public String hello();
}
