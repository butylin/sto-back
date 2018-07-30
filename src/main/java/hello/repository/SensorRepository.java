package hello.repository;

import hello.model.Sensor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by serg on 2018-07-25.
 */
public interface SensorRepository extends CrudRepository<Sensor, Integer> {
    //List<Sensor> getAll();

    @Override
    List<Sensor> findAll();

//    @Query(value = "ALTER TABLE sensor_data MODIFY COLUMN :columnName INT(11)", nativeQuery = true)
//    void addParameterColumn(@Param("columnName") String columnName);


}
