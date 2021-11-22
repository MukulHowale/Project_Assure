package com.constructweekproject.Assure.dto;

import com.constructweekproject.Assure.entity.Hospitals;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HospitalLocationDTO {

    private Long bookingId;
    private String policyName;
    private String Location;
    private String Hospital;

}
