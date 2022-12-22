package com.example.demo.checkpoint;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("sum2")
public class DemoController {
    @GetMapping("/")
    public String demo(@RequestParam int number1, @RequestParam int number2, Model model) {
        int sum = number1 + number2;
        model.addAttribute("sum", sum);
        model.addAttribute("number1",number1);
        model.addAttribute("number2",number2);
        return "demo";
    }
    @ModelAttribute("sum2")
    public int initSum() {
        return 0;
    }
    @GetMapping("/level2")
    public String level2() {
        return "myPage";
    }
    @PostMapping("/level2")
    public String handleRequest(@RequestParam("num2") int num2, @ModelAttribute("sum2") int sum2,Model model) {
        sum2 += num2;
        model.addAttribute("sum2", sum2);
        model.addAttribute("num2",num2);
        return "myPage";
    }

}