package exort.se418.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;

@Configuration
public class FeignClientConfiguration{

	@Bean
	public Contract feignContact(){
		return new Contract.Default();
	}
}
