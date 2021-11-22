package com.constructweekproject.Assure.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long locationId;
    String name;

    @ManyToMany(mappedBy = "locations")
    public List<Policy> policies = new ArrayList<>();


    @OneToMany(mappedBy = "location")
    private List<Hospitals> hospitalsList = new ArrayList<>();


    public void addHospital(Hospitals hospital){
        this.hospitalsList.add(hospital);
    }

    public void addPolicies(Policy policy){
    this.policies.add(policy);
    }


}
