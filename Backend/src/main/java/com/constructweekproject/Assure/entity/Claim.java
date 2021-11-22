package com.constructweekproject.Assure.entity;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private String name;
    private Long aadharNumber;

    @ManyToOne
    private Hospitals hospitals;

    private Date dateOfTreatment;
    private Date submissionDate;
    private String status;
    private String claimItem;
    private Float amountToClaim;
    private Boolean preauthorizedConfirmation;
    private Boolean followUpVisits;

    @OneToMany
    @JoinColumn(name="claim_id")
    private List<Document> documents = new ArrayList<>();

    @ManyToOne
    private Members member;

    @ManyToOne
    private User user;

    @ManyToOne
    private PolicyBookings policyBookings;

    public void addDocuments(Document document) {
        this.documents.add(document);
    }
}
