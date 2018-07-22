package hello.controller;

import hello.model.Event;
import hello.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by serg on 21-Jul-18.
 */
@RestController
@RequestMapping("events")
@CrossOrigin(origins = "http://localhost:8000")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping("/all")
    public List<Event> getAll(){
        return eventService.findAll();
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Event> add(@RequestBody Event event){
        Event res = eventService.save(event);
        return new ResponseEntity<Event>(res, HttpStatus.OK);
    }

}
