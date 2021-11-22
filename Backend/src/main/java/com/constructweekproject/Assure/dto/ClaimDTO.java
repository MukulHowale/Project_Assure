package com.constructweekproject.Assure.dto;

import com.constructweekproject.Assure.entity.Document;
import com.constructweekproject.Assure.entity.Members;
import com.constructweekproject.Assure.entity.PolicyBookings;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClaimDTO {

    private Long id;
    private Long memberId;
    private String userName;
    private Date dateOfClaim;
    private Float amountToClaim;
    private Date submissionDate;
    private String nameOfMember;
    private String status;
    private String claimItem;
    private String policyBookingName;
}
