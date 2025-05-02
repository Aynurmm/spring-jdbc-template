package az.academy.turing.springdemo.domain.service;

import az.academy.turing.springdemo.domain.entity.UserEntity;
import az.academy.turing.springdemo.domain.exception.NotfoundException;
import az.academy.turing.springdemo.domain.mapper.UserMapper;
import az.academy.turing.springdemo.domain.model.dto.request.CreateUserRequest;
import az.academy.turing.springdemo.domain.model.dto.request.UpdateUserRequest;
import az.academy.turing.springdemo.domain.model.dto.response.UserResponse;
import az.academy.turing.springdemo.domain.model.enums.Status;
import az.academy.turing.springdemo.domain.repository.UserDaoImpl;
import az.academy.turing.springdemo.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private  final UserMapper userMapper;

    public List<UserResponse>findAll(){
        List<UserEntity>entityList=userRepository.getAll();
        return entityList.stream().map(userMapper::toDto).collect(Collectors.toList());
    }
    public UserResponse createUser(CreateUserRequest userRequest){
        UserEntity userEntity=new UserEntity();
        userEntity.setName(userRequest.getName());
        userEntity.setEmail(userRequest.getEmail());
        userEntity.setGroup(userRequest.getGroup());
        UserEntity savedentity=userRepository.save(userEntity);
        return userMapper.toDto(savedentity);
    }

    public UserResponse updateUser(Long id, UpdateUserRequest userRequest){
            UserEntity userEntity=userRepository.findbyId(id).orElseThrow(()->new NotfoundException("user not found wuth id: "+id));
            userEntity.setName(userRequest.getName());
            userEntity.setEmail(userRequest.getEmail());
            userEntity.setGroup(userRequest.getEmail());
            UserEntity updatedEntity=userRepository.save(userEntity);

            return userMapper.toDto(updatedEntity);
    }

    public void hardDeleteUser(Long id) {
        //hard delete
        userRepository.deletebyId(id);
    }
    public void softDeleteUser(Long id){
        //soft delete
        UserEntity deletedUser=userRepository.findbyId(id)
                .orElseThrow(()->new NotfoundException("user not found with id: "+id));
        userRepository.updateStatusById(id,Status.DELETED.name());
        System.out.println(deletedUser.getId());

    }}

