package se.systementor.backend2start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan
public class FetchCustomers implements CommandLineRunner {

    @Autowired
    private se.systementor.backend2start.Utils.DataSeeder dataSeeder;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Kör fetcbcustomers");

    }

}
