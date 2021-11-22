package com.constructweekproject.Assure.dto;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonFilter("UserFilter")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long userId;
    private String userName;
    private String userEmail;
    private String userMobile;
    private String userPass;
    private String otp;

}
