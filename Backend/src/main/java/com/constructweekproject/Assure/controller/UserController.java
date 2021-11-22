package com.constructweekproject.Assure.controller;

import com.constructweekproject.Assure.dto.LoginDTO;
import com.constructweekproject.Assure.dto.PolicyBookingsGetListDTO;
import com.constructweekproject.Assure.dto.UserDTO;
import com.constructweekproject.Assure.service.UserService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<String> getUserName(@PathVariable Long userId) {
        String userName = userService.getUserName(userId);
        return new ResponseEntity<>(userName, HttpStatus.FOUND);
    }

    //Authenticating and registering a new user
    @PostMapping("/user/authenticate")
    public ResponseEntity authenticateUser(@RequestBody UserDTO userDTO){
        // filtering out and sending just the user mail and mobile for authentication and otp transfer to the user
        if(userDTO.getOtp().equals("")){

            SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("userName","userEmail","userMobile","userPass");

            FilterProvider filterProvider = new SimpleFilterProvider()
                    .addFilter("UserFilter",filter);

            MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(userDTO);

            mappingJacksonValue.setFilters(filterProvider);

            userService.authenticateUser(mappingJacksonValue);

            return ResponseEntity.ok("OTP sent");

        }

        // When the otp is provided, user is verified and registered in database
        Long userID = userService.registerUser(userDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userID)
                .toUri();

        return ResponseEntity.created(location).body(userID);
    }

    // Login request
    @PostMapping("/user/getUser")
    public ResponseEntity getUserDetails(@RequestBody LoginDTO loginDTO){
        Long userId = userService.getUserDetails(loginDTO);

        return new ResponseEntity(userId, HttpStatus.OK);
    }

    // Deleting phone-otp relation
    @PostMapping("/user/phoneotp")
    public ResponseEntity removePhoneOTP(@RequestBody UserDTO userDTO){
        userService.removePhoneOTP(userDTO);

        return new ResponseEntity(HttpStatus.OK);
    }

    @Bean
    public WebMvcConfigurer configurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/*").allowedOrigins("*");
            }
        };
    }

}
