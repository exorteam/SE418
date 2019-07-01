package exort.se418.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;

import exort.se418.config.FeignClientConfiguration;
import feign.Param;
import feign.RequestLine;

@FeignClient(value="ladder")
public interface FeignService{
	@RequestLine("GET /ladder?start={start}&end={end}")
	public List<String> generateLadder(@Param("start") String start,@Param("end") String end);
}
