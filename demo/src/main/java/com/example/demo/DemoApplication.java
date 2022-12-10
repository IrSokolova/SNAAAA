package com.example.demo;

import com.example.demo.model.TrainModel;
import com.example.demo.repository.TrainRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner init(TrainRepository trainRepository) {
        return args -> {
//            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
//                TrainModel train = new TrainModel(name, name.toLowerCase() + "@domain.com");
//                userRepository.save(train);
//            });
            TrainRepository.findAll().forEach(System.out::println);
        };
    }

}
