package az.academy.turing.springdemo.domain.repository;

public class UserQuery {
    public static final String query="insert into users (name, email, group_name) values(?,?,?)";
    public static final String query1="select * from users";
}
