package com.constructweekproject.Assure.dto;

import com.constructweekproject.Assure.entity.*;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ToClaimDTO {
    private String type;
    private Long aadharNumber;
    private String nameOfMember;

    private String hospitalName;

    private Date dateOfTreatment;
    private Date submissionDate;
    private String status;
    private String claimItem;
    private Float amountToClaim;
    private Boolean preauthorizedConfirmation;
    private Boolean followUpVisits;


}
