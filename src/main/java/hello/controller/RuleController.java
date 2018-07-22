package hello.controller;

import hello.model.Rule;
import hello.model.RuleTest;
import org.springframework.web.bind.annotation.*;

/**
 * Created by serg on 21-Jul-18.
 */
@RestController
@RequestMapping("rules")
@CrossOrigin(origins = "http://localhost:8000")
public class RuleController {

    @PostMapping(value = "/add")
    public @ResponseBody Rule add(@RequestBody Rule rule){
        System.out.println(rule);

        return rule;
    }
}
