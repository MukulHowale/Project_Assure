package com.constructweekproject.Assure.service;


import com.constructweekproject.Assure.dto.MembersDTO;
import com.constructweekproject.Assure.dto.PolicyBookingsGetListDTO;
import com.constructweekproject.Assure.entity.Members;
import com.constructweekproject.Assure.exception.UserExists;
import com.constructweekproject.Assure.modelmapper.ModelMapperClass;
import com.constructweekproject.Assure.repository.MembersRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MembersService {


    @Autowired
    MembersRepository membersRepository;

    @Autowired
    ModelMapperClass modelmapper;

    public List<MembersDTO> getallmembers() {
        List<Members> allmembers = membersRepository.findAll();
        List<MembersDTO> allmembersdto = modelmapper.modelMapper().map(allmembers, new TypeToken<List<MembersDTO>>() {}.getType());
//        List<MembersDTO> allmembersdto = new ArrayList<>();
//        MembersDTO membersDTO = new MembersDTO();
//
//        for (Members allmembers1 : allmembers) {
//            modelmapper.map(allmembers1, membersDTO);
//            allmembersdto.add(membersDTO);
//        }
        return allmembersdto;

    }


    public MembersDTO memberbyid(Long id) {
        Members members=membersRepository.findById(id).get();
        MembersDTO membersDTO = new MembersDTO();
        modelmapper.modelMapper().map(members,membersDTO);
        return membersDTO;
    }


    public String postmember(MembersDTO membersDTO) {

        List<Members> allmembers=membersRepository.findAll();

        for(Members members1:allmembers) {
            if (members1.getEmail().equals(membersDTO.getEmail()))
                      throw new UserExists("Email Already Registered");
            if (members1.getMobile().equals(membersDTO.getMobile()))
                throw new UserExists(("Mobile number already exist"));
        }

        Members members=new Members();
        modelmapper.modelMapper().map(membersDTO,members);
        Members members1 = membersRepository.save(members);
            return new String("saved");
        }



    public MembersDTO updatemember(MembersDTO membersDTO) {
        Members members = new Members();
        modelmapper.modelMapper().map(membersDTO, members);
        List<Members> allmembers = membersRepository.findAll();

        for (Members members1 : allmembers) {
            if (members1.getEmail().equals(membersDTO.getEmail())) {
                modelmapper.modelMapper().map(members, members1);
                try {
                    membersRepository.save(members1);
                    return membersDTO;
                } catch (Exception e) {
                    return null;
                }
            }
        }
        throw new UserExists("member does''t exist");
    }


    public String deletemember(Long id) {
      Members members = membersRepository.findById(id).get();
        try{
            membersRepository.delete(members);
            return new String("Deleted");
        }catch(Exception es){
            return new String("Error");
        }

    }
}
