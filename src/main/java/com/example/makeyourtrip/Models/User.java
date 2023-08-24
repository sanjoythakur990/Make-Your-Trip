package com.example.makeyourtrip.Models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String name;
    private String emailId;
    private Integer age;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Booking> bookingList=new ArrayList<>();
}
