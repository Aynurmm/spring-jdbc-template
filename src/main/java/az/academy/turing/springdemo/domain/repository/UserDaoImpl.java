package az.academy.turing.springdemo.domain.repository;

import az.academy.turing.springdemo.domain.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UserDaoImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public UserEntity save(UserEntity user) {
        jdbcTemplate.update(UserQuery.query, user.getName(), user.getEmail(), user.getGroup());
        return user;
    }

    @Override
    public List<UserEntity> getAll() {
        return jdbcTemplate.query(UserQuery.query1, new UserRepositoryMapper());
    }

    @Override
    public Optional<UserEntity> findbyId(long id) {
        return Optional.of(jdbcTemplate.queryForObject(UserQuery.query2, new UserRepositoryMapper(), id));
    }

    @Override
    public void deletebyId(long id) {
        jdbcTemplate.update(UserQuery.getQuery3, id);
    }
}
