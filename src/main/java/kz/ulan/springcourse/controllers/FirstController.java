package kz.ulan.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model){

        //System.out.println("Hello" + name + " " + surname);

        model.addAttribute("key","Hello" + " " + name + " " + surname);

        return "first/hello";
    }


    @GetMapping("/goodbye")
    public String goodbyePage(){
        return "first/goodbye";
    }


    @GetMapping("/calculator")
    public String calculate(@RequestParam("value1") int a, @RequestParam("value2") int b,
                            @RequestParam("action") String action, Model model){
        switch (action){
            case "multiplication": model.addAttribute("key", "a * b = " + (a * b));
            break;
            case "addition": model.addAttribute("key", "a + b = " + (a + b));
            break;
            case "subtraction": model.addAttribute("key", "a - b = " +  (a - b));
            break;
            case "division": model.addAttribute("key", "a / b = " + (a / b));
            break;
        }

        return "/first/calculator";

    }

}
