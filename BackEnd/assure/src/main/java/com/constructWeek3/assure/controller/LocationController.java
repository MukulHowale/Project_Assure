package com.constructWeek3.assure.controller;

import com.constructWeek3.assure.entity.Location;
import com.constructWeek3.assure.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class LocationController {

    @Autowired
    LocationService locationService;
    @PostMapping("/claims/location")
    public ResponseEntity<String> addLocation(@RequestBody Location location){
        String msg = locationService.addLocation(location);
        return new ResponseEntity<String>(msg,HttpStatus.OK);
    }



    @GetMapping("/claims/location")
    public List<Location> getAllLocation(){
         List<Location> locations = locationService.getAllLocation();
        return locations;
    }



}
