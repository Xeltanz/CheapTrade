package hu.elte.alkfejl.cheaptrade.config;

import hu.elte.alkfejl.cheaptrade.domain.user.User;
import hu.elte.alkfejl.cheaptrade.domain.user.UserRepository;
import hu.elte.alkfejl.cheaptrade.domain.user.UserService;
import hu.elte.alkfejl.cheaptrade.domain.user.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class ApplicationConfiguration {


    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserServiceImpl(userRepository);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserService userService) {
        return args -> {
            User kristof = new User(1L, LocalDate.now(), "Ferenc", "kristofka@citromail.hu", "pass");
            userService.save(kristof);
        };
    }
}
