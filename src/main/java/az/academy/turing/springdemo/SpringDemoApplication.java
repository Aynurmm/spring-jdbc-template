package az.academy.turing.springdemo;

import az.academy.turing.springdemo.domain.entity.UserEntity;
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
//        userRepository.save(new UserEntity("Ali", "ali@gmail.com", "jbe1110"));
//        userRepository.save(new UserEntity("Ayshe", "ayshe09@gmail.com", "fe1220"));
        userRepository.save(new UserEntity("Nermin", "nermind09@gmail.com", "devops1210"));
//        System.out.println(userRepository.getAll());
    }
}
