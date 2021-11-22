package com.constructweekproject.Assure.service;

import antlr.collections.impl.LList;
import com.constructweekproject.Assure.entity.Location;
import com.constructweekproject.Assure.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;


    public String addLocation(Location location) {
        locationRepository.save(location);
        return  "Location has been added";
    }



    public List<Location> getAllLocation() {
        List<Location> locations = locationRepository.findAll();
        return locations;
    }


}
