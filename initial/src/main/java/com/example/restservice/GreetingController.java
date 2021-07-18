
package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    public ParseJSON  parseJSON ;

  //  @Autowired
 //   private WeightedGraph weightedGraph;

  /*  @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }*/
   /*  @Autowired
    private GreetingService greetingService;
    @GetMapping("/greeting__")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return greetingService.getAge();
    }*/
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    @GetMapping("/greeting_")
    public Greeting greeting_(@RequestParam(value = "name", defaultValue = "World") String name,@RequestParam(value = "name2", defaultValue = "World") String name2) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name,name2));
    }
    @GetMapping({"/myfoos/optional", "/myfoos/optional/{id}"})
    @ResponseBody
    public String getFooByOptionalId(@PathVariable(required = false) String id){
        return "ID: " + id;
    }
    @GetMapping("/api/foos")
    @ResponseBody
    public String addFoo(@RequestParam(name = "id") int fooId, @RequestParam String name) {
        return "ID: " + fooId + " Name: " + name;
    }

}