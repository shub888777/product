package com.shubham.Product.Users;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private PasswordEncoder passwordEncoder;

    public Users createUser(UserRequestDto userdto){
        Users users=new Users();
        users.setEmail(userdto.getEmail());
        users.setPassword(passwordEncoder.encode(userdto.getPassword()));
        users.setRole(List.of("USER"));
        users.setUsername(userdto.getUsername());
        return userRepo.save(users);
    }
    public Users createAdmin(UserRequestDto userdto){
        Users users=new Users();
        users.setUsername(userdto.getUsername());
        users.setEmail(userdto.getEmail());
        users.setPassword(passwordEncoder.encode(userdto.getPassword()));
        users.setRole(List.of("ADMIN"));


        return userRepo.save(users);
    }
    public List<Users> getAllUser(){
        return userRepo.findAll();
    }
    public Users getUserByUsername(String username){
        return userRepo.findByUsername(username);
    }

}

