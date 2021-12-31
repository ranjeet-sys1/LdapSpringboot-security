package com.app.LdapSpringSecurity.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
