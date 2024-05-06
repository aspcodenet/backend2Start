package se.systementor.backend2start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Objects;

@SpringBootApplication
public class Backend2StartApplication {

    public static void main(String[] args) {


        if(args.length == 0) {
            SpringApplication.run(Backend2StartApplication.class, args);
        }else if(Objects.equals(args[0], "consoleapp1")){
            SpringApplication application = new SpringApplication(ConsoleApp1.class);
            application.setWebApplicationType(WebApplicationType.NONE);
            application.run(args);

        }else if(Objects.equals(args[0], "fetchcustomers")){
            SpringApplication application = new SpringApplication(FetchCustomers.class);
            application.setWebApplicationType(WebApplicationType.NONE);
            application.run(args);

        }
    }



}
