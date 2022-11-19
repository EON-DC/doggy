package com.doggy;

import com.doggy.model.Post;
import com.doggy.model.User;
import com.doggy.repository.PostRepository;
import com.doggy.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class EonApplication {

    public static void main(String[] args) {
        SpringApplication.run(EonApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PostRepository posts, UserRepository users, PasswordEncoder encoder) {
        return args -> {
            users.save(new User("park", encoder.encode("password"), "ROLE_USER"));
            users.save(new User("admin", encoder.encode("password"), "ROLE_ADMIN"));
            posts.save(new Post("hello, world!", "hello-word", "Welcome to my blog!", "park"));

        };
    }

}
