package kursovaya.kr17.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("title", "main");
        return "main";
    }

    @GetMapping("/map")
    public String map(Model model) {
        model.addAttribute("title", "map");
        return "map";
    }

}
