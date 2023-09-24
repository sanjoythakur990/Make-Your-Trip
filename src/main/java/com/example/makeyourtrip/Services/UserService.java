package com.example.makeyourtrip.Services;

import com.example.makeyourtrip.Models.User;
import com.example.makeyourtrip.Repositories.UserRepository;
import com.example.makeyourtrip.RequestDTOs.AddUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JavaMailSender emailSender;
    public String addUser(AddUserDto addUserDto){
        User user=User.builder().name(addUserDto.getName()).age(addUserDto.getAge()).emailId(addUserDto.getEmailId()).build();
        userRepository.save(user);
//        return "User has been saved successfully.";

        SimpleMailMessage mailMessage=new SimpleMailMessage();

        String body="Hi! "+user.getName()+" Welcome to Make Your Trip Website, book your flights, trains, buses conveniently.";
        mailMessage.setSubject("Welcome to Make Your Trip");
        mailMessage.setFrom("rahulghogh9444@gmail.com");
        mailMessage.setTo(user.getEmailId());
        mailMessage.setText(body);

        emailSender.send(mailMessage);
        return "User has been saved successfully.";
    }

}
