package com.ifi.trainer_api;

import com.ifi.trainer_api.bo.Pokemon;
import com.ifi.trainer_api.bo.Trainer;
import com.ifi.trainer_api.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootApplication
public class TrainerApi {

    @Bean
    @Autowired
    public CommandLineRunner demo(TrainerRepository repository) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return (args) -> {
            var ash = new Trainer("Ash");
            var pikachu = new Pokemon(25, 18);
            ash.setPassword(bCryptPasswordEncoder.encode("ash_password"));
            ash.setTeam(List.of(pikachu));

            var misty = new Trainer("Misty");
            var staryu = new Pokemon(120, 18);
            var starmie = new Pokemon(121, 21);
            misty.setPassword(bCryptPasswordEncoder.encode("misty_password"));
            misty.setTeam(List.of(staryu, starmie));

            // save a couple of trainers
            repository.save(ash);
            repository.save(misty);
        };
    }

    public static void main(String... args){
        SpringApplication.run(TrainerApi.class, args);
    }

}