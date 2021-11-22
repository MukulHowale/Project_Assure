// package com.constructWeek3.assure.entity;

// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;
// import lombok.ToString;

// import javax.persistence.*;
// import java.util.HashSet;
// import java.util.Set;

// @Entity
// @NoArgsConstructor
// @Getter
// @Setter
// @ToString
// public class Policy {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long policyId;
//     private String policyName;
//     private String roomRentLimit;
//     private Float claimBonus;
//     private String pedWaitingPeriod; //waiting period of pre-existing-disease cover
//     private Float copayPercent;
//     private Boolean isCriticalIllnessCovered;
//     private Boolean isMaternityCovered;
//     private Boolean isRestorationBenefitsCovered;
//     private Float premiumUpto18;
//     private Float premiumUpto45;
//     private Float premiumUpto60;
//     private Float premiumBeyond60;
//     private Float coverAmount1;
//     private Float coverAmount2;
//     private Float coverAmount3;
//     private Integer tenure1;
//     private Integer tenure2;
//     private Integer tenure3;

//     @ManyToMany(fetch = FetchType.LAZY)
//     private Set<Hospitals> hospitals = new HashSet<>();

//     @OneToMany(fetch = FetchType.LAZY)
//     private Set<Location> locations = new HashSet<>();

//     @OneToMany(fetch = FetchType.LAZY)
//     private Set<PolicyBookings> policyBookings = new HashSet<>();


// }


package com.constructweekproject.Assure.entity;

        import com.fasterxml.jackson.annotation.JsonIgnore;
        import lombok.*;

        import javax.persistence.*;
        import java.util.ArrayList;
        import java.util.HashSet;
        import java.util.List;
        import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@Table( uniqueConstraints = { @UniqueConstraint(columnNames = {"policyId"})})
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long policyId;
    private String policyName;
    private String roomRentLimit;
    private Float claimBonus;
    private String pedWaitingPeriod; //waiting period of pre-existing-disease cover
    private Float copayPercent;
    private Boolean isCriticalIllnessCovered;
    private Boolean isMaternityCovered;
    private Boolean isRestorationBenefitsCovered;
    private Float premiumUpto18;
    private Float premiumUpto45;
    private Float premiumUpto60;
    private Float premiumBeyond60;
    private Float coverAmount1;
    private Float coverAmount2;
    private Float coverAmount3;
    private Integer tenure1;
    private Integer tenure2;
    private Integer tenure3;

    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Set<Hospitals> hospitals = new HashSet<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "POLICY_LOCATION",
            joinColumns = @JoinColumn(name = "POLICY_IDs"),
            inverseJoinColumns = @JoinColumn(name = "LOCATION"))
    public List<Location> locations = new ArrayList<>();


    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Set<PolicyBookings> policyBookings = new HashSet<>();

    public void addPolicyBooking(PolicyBookings policyBooking) {
        policyBookings.add(policyBooking);
    }

    public void addLocation(Location location){
        this.locations.add(location);
    }

    public void addHospital(Hospitals hospital) {
        hospitals.add(hospital);
    }
}
