package hello.controller;

import hello.model.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;


@CrossOrigin(origins = "http://localhost:8000")
@RestController
public class GreetingController {
    private static final String template = "Greetings, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "sir") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
