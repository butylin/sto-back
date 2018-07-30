package hello.service;

import hello.model.Sensor;
import hello.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serg on 20-Jul-18.
 */
@Service
public class SensorServiceImpl implements SensorService {
    @Autowired
    SensorRepository sensorRepository;

    @Override
    //@Query(value = "SELECT id, name FROM events", nativeQuery=true)
    public List<Sensor> getAllSensors() {

        return sensorRepository.findAll();
    }
}
