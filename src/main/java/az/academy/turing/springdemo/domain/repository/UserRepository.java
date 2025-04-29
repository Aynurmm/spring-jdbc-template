package az.academy.turing.springdemo.domain.repository;

import az.academy.turing.springdemo.domain.entity.UserEntity;

import java.util.List;
import java.util.Optional;


public interface UserRepository {
    UserEntity save(UserEntity user);
    List<UserEntity> getAll();
   Optional<UserEntity> findbyId(long id);
    void deletebyId(long id);

}
