package az.academy.turing.springdemo;

import az.academy.turing.springdemo.domain.entity.UserEntity;
import az.academy.turing.springdemo.domain.model.dto.request.CreateUserRequest;
import az.academy.turing.springdemo.domain.model.dto.request.UpdateUserRequest;
import az.academy.turing.springdemo.domain.repository.UserRepository;
import az.academy.turing.springdemo.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringDemoApplication implements CommandLineRunner {
    private final UserRepository userRepository;
    private final UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        userRepository.save(new User("Aysel", "aysel@gmail.com", "jbe1110"));
//        userRepository.save(new UserEntity("Ali", "ali@gmail.com", "jbe1110"));
//        userRepository.save(new UserEntity("Ayshe", "ayshe09@gmail.com", "fe1220"));
//        userRepository.save(new UserEntity("Nermin", "nermind09@gmail.com", "devops1210"));
//        userRepository.save(new UserEntity("leyla","leyla@gmail.com","fe110"));
//        userRepository.save(new UserEntity("Veli","veliyev@gmail.com","ds510"));
//        userService.softDeleteUser(9L);
//        userService.hardDeleteUser(13l);
//        userRepository.findbyId(2l);
//        userService.createUser(new CreateUserRequest("Lale","lale@gmail.com","jbe1210"));
        System.out.println(userService.findAll());
        userService.updateUser(8L, UpdateUserRequest.builder().name("Vali")
                .email("vali@gmail.com")
                .group("jbe1210")
                .build());
//        System.out.println(userRepository.getAll());
    }
}
