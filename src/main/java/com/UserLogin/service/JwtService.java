package com.UserLogin.service;

import com.UserLogin.entiry.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.algorithm.key}")
    private String algorithmKey;

    @Value("${jwt.algorithm.expirydate}")
    private int expiryDate;

    @Value("${jwt.algorithm.issuer}")
    private String issuer;
    private static final String USER_NAME="username";

    private Algorithm algorithm;


    @PostConstruct
    private void postConstruct() throws UnsupportedEncodingException {

        this.algorithm = com.auth0.jwt.algorithms.Algorithm.HMAC256(algorithmKey);
    }

    public String generateJwttoken(User user){
        return JWT.create()
                .withClaim(USER_NAME, user.getName())
                .withExpiresAt(new Date(System.currentTimeMillis()+expiryDate))
                .withIssuer(issuer)
                .sign(algorithm);
    }

}
