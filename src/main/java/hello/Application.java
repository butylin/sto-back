package hello;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by serg on 15-Jul-18.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper()
                .enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT )
                .enable(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY );
    }

    @Bean
    public

//    @Bean
//    public Connection connection(){
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            return DriverManager.getConnection("jdbc:mysql://localhost:3306/sto","sto","sto");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}
