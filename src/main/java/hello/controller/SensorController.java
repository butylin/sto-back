package hello.controller;

import hello.model.Sensor;
import hello.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by serg on 21-Jul-18.
 */
@CrossOrigin(origins = "http://localhost:8000")
@RestController
@RequestMapping("sensors")
public class SensorController {
    @Autowired
    SensorService sensorService;


    @GetMapping("/all")
    private List<Sensor> getAllSensors(){
        List<Sensor> res = sensorService.getAllSensors();
        System.out.println(res);
        return res;
    }
}
