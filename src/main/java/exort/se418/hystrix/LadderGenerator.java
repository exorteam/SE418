package exort.se418.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

import exort.se418.component.Ladder;

public class LadderGenerator extends HystrixCommand<String> {

	private final String begin,end;

	public LadderGenerator(String begin,String end){
		super(Setter
				.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ladder"))
				.andCommandPropertiesDefaults(
					HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(20000)));
		this.begin = begin;
		this.end = end;
	}
	
	@Override
	protected String run(){
		return Ladder.run(begin,end).toString();
	}

	@Override
	protected String getFallback(){
		return "Generation time beyond 20s";
	}
}
