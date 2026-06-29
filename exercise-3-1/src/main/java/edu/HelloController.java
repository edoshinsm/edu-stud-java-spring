package edu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name", defaultValue = "anonim") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
}
