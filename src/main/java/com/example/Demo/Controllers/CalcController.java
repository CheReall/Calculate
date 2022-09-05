package com.example.Demo.Controllers;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalcController {
    // Калькулятор с использованием get параметров
    //Загрузка формы калькулятора
    @GetMapping("/get/calculating")
    public String GetView(){
        return "getCalc";
    }
    //Обработка формы калькулятора
    @GetMapping("/get/process")
    public String GetController ( @RequestParam int a, @RequestParam int b, @RequestParam String action, Model model){
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("action", action);
        double result;
        switch (action) {
            case "summa":
                result = a + b;
                break;
            case "sub":
                result = a - b;
                break;
            case "multi":
                result = a * b;
                break;
            case "div":
                result = a / b;
                break;
            default:
                result = 0;
                break;
        }
        model.addAttribute("result", result);
        return "getCalc";
    }

    // Калькулятор с использованием метода Post
    //Загрузка формы калькулятора
    @GetMapping("/post/calculating")
    public String PostView(){
        return "postCalc";
    }
    //Обработка формы калькулятора
    @PostMapping("/post/process")
    public String PostController(@RequestParam int a, @RequestParam int b,
                                 @RequestParam String action, Model model) {
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("action", action);

        double result;

        switch (action) {

            case "summa":
                result = a + b;
                break;
            case "sub":
                result = a - b;
                break;
            case "multi":
                result = a * b;
                break;
            case "div":
                result = a / b;
                break;
            default:
                result = 0;
                break;
        }
        model.addAttribute("result", result);
        return "postCalc";
    }
}
