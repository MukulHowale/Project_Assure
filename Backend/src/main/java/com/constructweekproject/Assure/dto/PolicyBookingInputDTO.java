package com.constructweekproject.Assure.dto;

import com.constructweekproject.Assure.entity.Members;
import lombok.*;

import java.util.Date;
import java.util.HashSet;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PolicyBookingInputDTO {

    private Float coverAmount;
    private Float premium;
    private Integer coverTenure;
    private HashSet<MembersDTO> members = new HashSet<>();

}
