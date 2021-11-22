package com.constructweekproject.Assure.dto;

import lombok.Data;

@Data
public class PolicyDTO {

    private Long policyId;
    private String policyName;
    private String roomRentLimit;
    private Float claimBonus;
    private String pedWaitingPeriod; //waiting period of pre-existing-disease cover
    private Float copayPercent;
    private Boolean isCriticalIllnessCovered;
    private Boolean isMaternityCovered;
    private Boolean isRestorationBenefitsCovered;
    private Float premium1;
    private Float premium2;
    private Float premium3;
    private Float coverAmount1;
    private Float coverAmount2;
    private Float coverAmount3;
    private Integer tenure1;
    private Integer tenure2;
    private Integer tenure3;

}
