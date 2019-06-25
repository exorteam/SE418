package exort.se418.serviceimpl;

import org.springframework.stereotype.Service;

import exort.se418.hystrix.LadderGenerator;
import exort.se418.service.LadderService;

@Service
public class LadderServiceImpl implements LadderService {
	public String generateLadder(String begin,String end){
		return new LadderGenerator(begin,end).execute();
	}
}
