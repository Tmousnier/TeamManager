package org.example.teammanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.example.teammanager", "org.example.teammanager.service", "org.example.teammanager.config"}) // Inclure les packages pertinents
public class TeamManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeamManagerApplication.class, args);
    }

}
