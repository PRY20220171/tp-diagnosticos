package com.example.backdiagnosticos;

import com.example.backdiagnosticos.config.CassandraConfig;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableRabbit
@SpringBootApplication
public class BackDiagnosticosApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackDiagnosticosApplication.class, args);
    }

}
