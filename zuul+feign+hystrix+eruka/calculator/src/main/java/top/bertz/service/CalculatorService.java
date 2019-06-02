package top.bertz.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import top.bertz.calculator.Calculate;

@Service
public class CalculatorService {

    private final RestTemplate restTemplate;

    public CalculatorService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ModelAndView calculate(String input) {
        ModelAndView mv = new ModelAndView("calculator");
        mv.addObject("input", input);

        try {
            Calculate cals = new Calculate();
            String ret = cals.cal(input);
            mv.addObject("result", ret);

        } catch (Exception e) {
            mv.addObject("result", "error");

        } finally {
            return mv;
        }
    }

    @HystrixCommand(fallbackMethod = "aid")
    public String tryHystrix(){
        return this.restTemplate.getForObject("http://localhost:8080/getMessage", String.class);
    }

    public String aid() {
        return "Hystrix Run!!!!";
    }
}
