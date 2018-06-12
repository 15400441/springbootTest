package com.controller;

import org.springframework.web.bind.annotation.RestController;



import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController {
	
	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
    
    //@RequestMapping maps all HTTP operations by default. Use @RequestMapping(method=GET) to narrow this mapping.
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name",defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
    
    
   
    

}