package kz.iitu.genresservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GenresServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenresServiceApplication.class, args);
    }

}
