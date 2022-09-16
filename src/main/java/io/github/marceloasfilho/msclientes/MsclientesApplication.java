package io.github.marceloasfilho.msclientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = "io.github.marceloasfilho.msclientes")
@EnableEurekaClient

public class MsclientesApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsclientesApplication.class, args);
    }
}
