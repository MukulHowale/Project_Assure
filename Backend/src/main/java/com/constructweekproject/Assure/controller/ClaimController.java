package com.constructweekproject.Assure.controller;

import com.constructweekproject.Assure.dto.ClaimDTO;
import com.constructweekproject.Assure.dto.ToClaimDTO;
import com.constructweekproject.Assure.entity.Claim;
import com.constructweekproject.Assure.modelmapper.ModelMapperClass;
import com.constructweekproject.Assure.service.ClaimService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ClaimController<T> {
    @Autowired
    ClaimService claimService;

    @Autowired
    ModelMapperClass modelMapper;

    @PostMapping("/claim/{policyBookingId}/{userId}/{memberId}")
    public ToClaimDTO claimInsurance(@PathVariable Long policyBookingId, @PathVariable Long userId, @PathVariable Long memberId, @RequestBody ToClaimDTO toClaimDTO) {
        Claim claim = new Claim();
        modelMapper.modelMapper().map(toClaimDTO, claim);
        String hospitalName = toClaimDTO.getHospitalName();
        Claim claimInsurance = claimService.claimInsurance(policyBookingId, userId, memberId, claim, hospitalName);

        ToClaimDTO returnClaimDTO = new ToClaimDTO();
        modelMapper.modelMapper().map(claimInsurance, returnClaimDTO);
        returnClaimDTO.setNameOfMember(claimInsurance.getMember().getName());
        if (claimInsurance.getHospitals()!=null) returnClaimDTO.setHospitalName(claimInsurance.getHospitals().getName());
        return returnClaimDTO;
    }

    @GetMapping("/claim/{userId}")
    public List<ClaimDTO> getAllTheClaims(@PathVariable Long userId){
        List<Claim> list = claimService.getAllTheClaims(userId);
        List<ClaimDTO> listOfClaimDTO = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            ClaimDTO claimDTO = new ClaimDTO();
            modelMapper.modelMapper().map(list.get(i), claimDTO);
            claimDTO.setUserName(claimService.getUserName(userId));
            listOfClaimDTO.add(claimDTO);
            claimDTO.setNameOfMember(list.get(i).getMember().getName());
            claimDTO.setMemberId(list.get(i).getMember().getMember_id());
            claimDTO.setPolicyBookingName(list.get(i).getPolicyBookings().getPolicyName());
        }

        return listOfClaimDTO;
    }
}
