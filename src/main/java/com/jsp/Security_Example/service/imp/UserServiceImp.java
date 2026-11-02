package com.jsp.Security_Example.service.imp;

import com.jsp.Security_Example.entity.User;
import com.jsp.Security_Example.repository.UserRespository;
import com.jsp.Security_Example.security.JwtService;
import com.jsp.Security_Example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRespository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public User signup(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public  String signin(User user){
//        User user1 = userRepo.findByUsername(user.getUsername())
//                .orElseThrow(()->new RuntimeException("Username not found"));

        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));


//        if(passwordEncoder.matches(user.getPassword(),user1.getPassword())){
//
//            String token = jwtService.generateToken(user1);
//
//            return "Signed in Successfully "+token;

        if(auth.isAuthenticated()){
            String token = jwtService.generateToken(user);
            return "User logged in successfully & Tocken is: " + token;
        }else {
            throw new RuntimeException("Password not match");
        }
    }

    public String greeting() {
        return "Hello World!";
    }
}
