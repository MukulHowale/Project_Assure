package com.constructweekproject.Assure.controller;

import com.constructweekproject.Assure.dto.MembersDTO;
import com.constructweekproject.Assure.entity.Members;
import com.constructweekproject.Assure.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MembersController {

    @Autowired
    MembersService membersService;

    @GetMapping("/get/allmembers")
    public ResponseEntity<List<MembersDTO>> getallmembers(){
        return new ResponseEntity<>(membersService.getallmembers(), HttpStatus.OK);
    }
    @GetMapping("/get/member/{id}")
    public  ResponseEntity<MembersDTO> getmemberbyid(@PathVariable Long id){

        return new ResponseEntity<>(membersService.memberbyid(id),HttpStatus.FOUND);
    }
    @PostMapping("/post/member/")
    public ResponseEntity<String> postmember(@RequestBody MembersDTO membersDTO){
        return new ResponseEntity<>(membersService.postmember(membersDTO),HttpStatus.CREATED);
    }
   @PutMapping("/put/member/")
    public MembersDTO updatemember(@RequestBody MembersDTO membersDTO){
        return membersService.updatemember(membersDTO);
   }

   @DeleteMapping("/delete/member/{id}")
    public String deletemember(@PathVariable Long id){

        return membersService.deletemember(id);
   }

}
