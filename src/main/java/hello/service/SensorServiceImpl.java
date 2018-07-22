package hello.service;

import hello.model.Sensor;
import org.springframework.stereotype.Service;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serg on 20-Jul-18.
 */
@Service
public class SensorServiceImpl implements SensorService {

    @Override
    //@Query(value = "SELECT id, name FROM events", nativeQuery=true)
    public List<Sensor> getAllSensors() {
        List<Sensor> result = new ArrayList<>();

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sto","sto","sto");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT `COLUMN_NAME` \n" +
                    "FROM `INFORMATION_SCHEMA`.`COLUMNS` \n" +
                    "WHERE `TABLE_SCHEMA`='sto' \n" +
                    "    AND `TABLE_NAME`='sensor_data'\n" +
                    "LIMIT 2, 9999;");

            while(rs.next()){
                result.add(new Sensor(rs.getString(1), rs.getString(1)));
            }


            con.close();
        }catch(Exception e){ System.out.println(e);}

        return result;
    }
}
