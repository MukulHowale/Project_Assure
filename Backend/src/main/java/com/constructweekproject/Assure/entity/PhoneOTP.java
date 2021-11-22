package com.constructweekproject.Assure.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PhoneOTP {

    @Id
    @GeneratedValue
    private Long id;

    private String userMobile;
    private String otp;

    public PhoneOTP(String userMobile, String otp) {
        this.userMobile = userMobile;
        this.otp = otp;
    }
}
