package com.api_example.service;

import com.api_example.dto.StudentDto;
import com.api_example.dto.UserDto;
import com.api_example.entity.Student;
import com.api_example.entity.User;
import com.api_example.repository.StudentRepository;
import com.api_example.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    public UserRepository userRepository;
    private final StudentRepository studentRepository;

    public UserService(UserRepository userRepository,
                       StudentRepository studentRepository) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
    }

    public void saveUser(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
//        user.setName(userDto.getName());
//        user.setMobile(userDto.getMobile());
//        user.setEmail(userDto.getEmial());
        userRepository.save(user);
    }

    public List<User> readUser() {
        List<User> user = userRepository.findAll();
        return user;
    }

    public User findById(Long id) {
        User user = userRepository.findById(id).get();
        return user;
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public UserDto updateUser(UserDto userDto, Long id) {
        User user = userRepository.findById(id).get();
        BeanUtils.copyProperties(userDto,user);
        User save = userRepository.save(user);
        UserDto usDto = new UserDto();
        BeanUtils.copyProperties(save,usDto);
        return usDto;

    }
}
