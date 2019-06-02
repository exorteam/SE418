package top.bertz.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

@RestController
public class GatewayController {

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("home");

        return mv;
    }

    @RequestMapping(value = {"/getMessage"}, method = RequestMethod.GET)
    public String message() {
        return "Hystrix not Run :(";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("login");

        return mv;
    }

}
