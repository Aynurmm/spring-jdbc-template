package az.academy.turing.springdemo.domain.mapper;

import az.academy.turing.springdemo.domain.entity.UserEntity;
import az.academy.turing.springdemo.domain.model.dto.response.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements EntityMapper<UserEntity, UserResponse> {

    @Override
    public UserEntity toEnt(UserResponse userResponse) {
        return UserEntity.builder()
                .name(userResponse.getName())
                .group(userResponse.getGroup())
                .build();
    }

    @Override
    public UserResponse toDto(UserEntity userEntity) {
        return UserResponse.builder()
                .name(userEntity.getName())
                .group(userEntity.getGroup())
                .build();
    }
}
