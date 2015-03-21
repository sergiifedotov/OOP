package web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 3/16/15
 */
@Controller
public class HelloController {
    public static final Logger log = Logger.getLogger(HelloController.class);

    @RequestMapping(value = "/hello.html", method = RequestMethod.GET)
    public String hello(Model model) {
        log.info("/hello.html controller");
        model.addAttribute("name", "Petro");
        return "hello";
    }

    @RequestMapping(value = "/great.html", method = RequestMethod.GET)
    public String great(@RequestParam String name, Model model) {
        log.info("/great.html controller");
        model.addAttribute("name", name);
        return "hello";
    }
}
