package se.systementor.backend2start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Backend2StartApplication {

    @Autowired
    private se.systementor.backend2start.Utils.DataSeeder dataSeeder;

    public static void main(String[] args) {
        SpringApplication.run(Backend2StartApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            dataSeeder.Seed();
        };
    }

}
