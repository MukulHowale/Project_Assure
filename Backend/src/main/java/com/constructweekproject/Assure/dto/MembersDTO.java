package com.constructweekproject.Assure.dto;

import com.constructweekproject.Assure.entity.PolicyBookings;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
public class MembersDTO {

    private String name;
    private String relation_with_user;
    private String dob;
    private String gender;
    private Boolean is_taking_medicines;
    private String city;
    private Boolean martial_status; //true for married
    private String email;
    private String aadhaar;
    private String mobile;
    private String occupation;
    private String height;
    private Float weight;
//    PolicyBookings policyBookings;
}
