package exort.se418.service;

import org.springframework.cloud.openfeign.FeignClient;

import exort.se418.config.FeignClientConfiguration;
import feign.Param;
import feign.RequestLine;

@FeignClient(value="ladder")
public interface FeignService{
	@RequestLine("GET /ladder?start={start}&end={end}")
	public String generateLadder(@Param("start") String start,@Param("end") String end);
}
