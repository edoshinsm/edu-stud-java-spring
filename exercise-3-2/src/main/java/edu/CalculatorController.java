package edu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CalculatorController {
    @GetMapping("/calc/{action}/{a}/{b}")
    public String add(
            @PathVariable("action") String action,
            @PathVariable("a") int a,
            @PathVariable("b") int b,
            Model model
    ) {
        String result;
        switch (action) {
            case "sum" -> result = a + " + " + b + " = " + (a + b);
            case "dif" -> result = a + " - " + b + " = " + (a - b);
            case "mul" -> result = a + " * " + b + " = " + (a * b);
            case "div" -> {
                if(b == 0) result = "Операция невозможна";
                else result = a + " / " + b + " = " + ((double) a / b);
            }
            case "xor" -> result = a + "^" + b + " = " + (a ^ b);
            case null, default -> result = "Неизвестная операция: " + action;
        }

        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("result", result);
        return "calc";
    }
}
