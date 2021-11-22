package com.constructweekproject.Assure.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticateUserDTO {

    private String userName;
    private String userEmail;
    private String userMobile;
    private String userPass;

}
