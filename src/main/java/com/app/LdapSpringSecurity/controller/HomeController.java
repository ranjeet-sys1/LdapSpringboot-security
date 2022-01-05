package com.app.LdapSpringSecurity.controller;


import com.app.LdapSpringSecurity.model.TokenGeneration;
import com.app.LdapSpringSecurity.utility.ResponseConstantIntegerValue;
import com.app.LdapSpringSecurity.utility.ResponseConstantValue;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class HomeController {
    
    public static final  Logger logger= LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/")
    public String index() {
        return "Welcome to the home page!";
    }
    @GetMapping("/open")
    public String getInfo(){
        String name="ranjeet";
        logger.info("LdapSecurity from info level : {}",name);
        logger.debug("LdapSecurity from DEBUG level : {}",name);
        return "I am open book person";
    }
    @PostMapping("/getToken")
    public ResponseEntity generateToken(@RequestBody TokenGeneration tokenGeneration){

        List<String> message= new ArrayList<>();
        String token = Jwts.builder()
                .setId(tokenGeneration.getId())
                .setSubject(tokenGeneration.getSubject())
                .setIssuer("ranjeet")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(10)))
                .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encode(tokenGeneration.getSecretKey().getBytes())).compact();
        message.add(token);
        message.add(ResponseConstantValue.SUCCESS_MESSAGE);
        message.add(String.valueOf(ResponseConstantIntegerValue.SUCCESS_RESPONSE));
        return new ResponseEntity(message, HttpStatus.OK);


    }

}
