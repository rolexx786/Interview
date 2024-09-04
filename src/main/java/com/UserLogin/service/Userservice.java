package com.UserLogin.service;

import com.UserLogin.entiry.Jwtresponse;
import com.UserLogin.entiry.LoginDto;
import com.UserLogin.entiry.User;
import com.UserLogin.exception.ResourceNotFoundException;
import com.UserLogin.exception.UserAlreadyExistsException;
import com.UserLogin.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service

public class Userservice {
    private UserRepository userRepository;
    private JwtService jwtService;

    public Userservice(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public User createUser(User user){
        Optional<User> byEmail = userRepository.findByEmail(user.getEmail());
        if (byEmail.isPresent()){
            throw new UserAlreadyExistsException("User with this email already exists");

        }
            String EncryptedPwd = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10));
            user.setPassword(EncryptedPwd);
            User save = userRepository.save(user);
            return save;

    }

    public Jwtresponse verifyLogin(LoginDto dto){
        User user = userRepository.findByEmail(dto.getEmail()).orElseThrow(() -> new ResourceNotFoundException("Invalid email"));
        if (BCrypt.checkpw(dto.getPassword(),user.getPassword())){
            String s = jwtService.generateJwttoken(user);

            Jwtresponse jwtresponse = new Jwtresponse();
            jwtresponse.setToken(s);
            jwtresponse.setType("JWT");
            return jwtresponse;



        }
        return null;



    }


}
