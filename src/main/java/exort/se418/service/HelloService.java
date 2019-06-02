package exort.se418.service;

import org.springframework.cloud.openfeign.FeignClient;

import exort.se418.config.HelloClientConfiguration;
import feign.Param;
import feign.RequestLine;

@FeignClient(url="localhost:8080",name="hello-service",configuration = HelloClientConfiguration.class)
public interface HelloService{
	@RequestLine("GET /hello/{who}")
	public String hello(@Param("who") String who);

	@RequestLine("GET /ladder/dog/cat")
	public String ladderDogToCat();
}
