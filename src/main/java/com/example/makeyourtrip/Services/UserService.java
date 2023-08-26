package com.example.makeyourtrip.Services;

import com.example.makeyourtrip.Models.User;
import com.example.makeyourtrip.Repositories.UserRepository;
import com.example.makeyourtrip.RequestDTOs.AddUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public String addUser(AddUserDto addUserDto){
        User user=User.builder().name(addUserDto.getName()).age(addUserDto.getAge()).emailId(addUserDto.getEmailId()).build();
        userRepository.save(user);
        return "User has been saved successfully.";
    }
}
