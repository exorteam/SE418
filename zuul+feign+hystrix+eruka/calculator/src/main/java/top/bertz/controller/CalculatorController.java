package top.bertz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import top.bertz.service.CalculatorService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public ModelAndView setInput() {
        ModelAndView mv = new ModelAndView("calculator");
        return mv;
    }

    @RequestMapping(value = {"/tryHystrix"}, method = RequestMethod.GET)
    public String hystrix() {
        return calculatorService.tryHystrix();
    }

    @RequestMapping(value = {"/result"}, method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ModelAndView getResult(HttpServletRequest res, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        String input = res.getParameter("input");

        return calculatorService.calculate(input);
    }

}
