package com.example.demo;

import com.example.demo.HalloWorld;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import java.util.concurrent.atomic.AtomicLong;


@Controller
public class MyController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hello-world")
    @ResponseBody
    public HalloWorld sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
        return new HalloWorld(counter.incrementAndGet(), String.format(template, name));
    }
}
