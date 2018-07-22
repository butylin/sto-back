package hello.controller;

import hello.model.User;
import hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by serg on 16-Jul-18.
 */
@CrossOrigin(origins = "http://localhost:8000")
@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    private List<User> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping(path = "/{id}")
    private User get(@PathVariable("id") Integer id){
        return userService.findById(id);
    }

    @PostMapping(value = "/add")
    private ResponseEntity<User> add(@RequestBody User user){
        System.out.println(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }


}
