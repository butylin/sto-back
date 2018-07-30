package hello.controller;

import hello.model.Rule;
import hello.model.RuleTest;
import hello.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by serg on 21-Jul-18.
 */
@RestController
@RequestMapping("rules")
@CrossOrigin(origins = "http://localhost:8000")
public class RuleController {
    @Autowired
    RuleService ruleService;

    @PostMapping(value = "/add")
    public @ResponseBody Rule add(@RequestBody Rule rule){
        System.out.println(rule);
        ruleService.save(rule);

        return rule;
    }
}
