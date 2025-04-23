package az.academy.turing.springdemo;

import az.academy.turing.springdemo.domain.entity.User;
import az.academy.turing.springdemo.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringDemoApplication implements CommandLineRunner {
    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        userRepository.save(new User("Aysel", "aysel@gmail.com", "jbe1110"));
        System.out.println(userRepository.getAll());
    }
}
