package az.academy.turing.springdemo.domain.repository;

import az.academy.turing.springdemo.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@RequiredArgsConstructor
@Repository
public class UserDaoImpl implements UserRepository{

    private final JdbcTemplate jdbcTemplate;

    @Override
    public User save(User user) {
       jdbcTemplate.update(UserQuery.query, user.getName(),user.getEmail(),user.getGroup());
       return user;
    }

    @Override
    public List<User> getAll() {
      return jdbcTemplate.query(UserQuery.query1,new UserRowMapper());
    }

    @Override
    public User findbyId(long id) {
        return null;
    }

    @Override
    public void deletebyId(long id) {

    }

    class UserRowMapper implements RowMapper<User>{

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            return User.builder()
                    .id(rs.getLong("id"))
                    .name(rs.getString("name"))
                    .email(rs.getString("email"))
                    .group(rs.getString("group_name"))
                    .build();
        }
    }
}
