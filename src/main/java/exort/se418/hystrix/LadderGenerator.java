package exort.se418.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class LadderGenerator extends HystrixCommand<String> {
	private final String begin,end;

	public LadderGenerator(String begin,String end){
		super(HystrixCommandGroupKey.Factory.asKey("Ladder"));
		this.begin = begin;
		this.end = end;
	}
	
	@Override
	protected String run(){
		return begin + " > " + end;
	}
}
