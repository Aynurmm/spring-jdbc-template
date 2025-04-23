package az.academy.turing.springdemo.domain.repository;

import az.academy.turing.springdemo.domain.entity.User;

import java.util.List;


public interface UserRepository {
    User save(User user);
    List<User> getAll();
    User findbyId(long id);
    void deletebyId(long id);

}
