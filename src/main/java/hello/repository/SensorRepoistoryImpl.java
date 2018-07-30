//package hello.repository;
//
//import hello.model.Sensor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
///**
// * Created by serg on 2018-07-25.
// */
//
//@Repository
//public class SensorRepoistoryImpl implements SensorRepository {
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    @Override
//    public Object saveRuleTrigger(Object o) {
//        super();
//        return null;
//    }
//
//    @Override
//    public Iterable saveAll(Iterable iterable) {
//        return null;
//    }
//
//    @Override
//    public Optional findById(Object o) {
//        return null;
//    }
//
//    @Override
//    public boolean existsById(Object o) {
//        return false;
//    }
//
//    @Override
//    public List<Sensor> findAll() {
//        return null;
//    }
//
//    @Override
//    public Iterable findAllById(Iterable iterable) {
//        return null;
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
//
//    @Override
//    public void deleteById(Object o) {
//
//    }
//
//    @Override
//    public void delete(Object o) {
//
//    }
//
//    @Override
//    public void deleteAll(Iterable iterable) {
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
//
//
////
////    @Override
////    public List<Sensor> getAll() {
////        List<Sensor> result = new ArrayList<>();
////        String sql = new StringBuilder()
////                .append("SELECT `COLUMN_NAME` ")
////                .append("FROM `INFORMATION_SCHEMA`.`COLUMNS` ")
////                .append("WHERE `TABLE_SCHEMA`='sto' ")
////                .append("AND `TABLE_NAME`='sensor_data' ")
////                .append("LIMIT 2, 9999;")
////                    .toString();
////
////        jdbcTemplate.query(sql, (rs, rowNum) -> new Sensor(rs.getString(1), rs.getString(1)))
////                .forEach(sensor -> result.add(sensor));
////
//////        jdbcTemplate.query(
//////                "SELECT id, first_name, last_name FROM customers WHERE first_name = ?", new Object[] { "Josh" },
//////                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
//////        ).forEach(customer -> log.info(customer.toString()));
////
//////        try{
////////            Class.forName("com.mysql.jdbc.Driver");
////////            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sto","sto","sto");
////////            Statement stmt = con.createStatement();
//////            Statement stmt = myConnection.createStatement();
//////            ResultSet rs = stmt.executeQuery("SELECT `COLUMN_NAME` \n" +
//////                    "FROM `INFORMATION_SCHEMA`.`COLUMNS` \n" +
//////                    "WHERE `TABLE_SCHEMA`='sto' \n" +
//////                    "    AND `TABLE_NAME`='sensor_data'\n" +
//////                    "LIMIT 2, 9999;");
//////
//////            while(rs.next()){
//////                result.add(new Sensor(rs.getString(1), rs.getString(1)));
//////            }
//////
//////
//////            //con.close();
//////        }catch(Exception e){ System.out.println(e);}
//
//        return result;
//    }
//}
