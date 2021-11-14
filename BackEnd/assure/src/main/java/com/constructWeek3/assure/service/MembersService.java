package com.constructWeek3.assure.service;


import com.constructWeek3.assure.dto.MembersDTO;
import com.constructWeek3.assure.dto.PolicyBookingsGetListDTO;
import com.constructWeek3.assure.entity.Members;
import com.constructWeek3.assure.exception.UserExists;
import com.constructWeek3.assure.modelmapper.ModelMapperClass;
import com.constructWeek3.assure.repository.MembersRepository;
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
    ModelMapper modelmapper;

    public List<MembersDTO> getallmembers() {
        List<Members> allmembers = membersRepository.findAll();
        List<MembersDTO> allmembersdto = modelmapper.map(allmembers, new TypeToken<List<MembersDTO>>() {}.getType());
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
        modelmapper.map(members,membersDTO);
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
        modelmapper.map(membersDTO,members);
        Members members1 = membersRepository.save(members);
            return new String("saved");
        }



    public MembersDTO updatemember(MembersDTO membersDTO) {
        Members members = new Members();
        modelmapper.map(membersDTO, members);
        List<Members> allmembers = membersRepository.findAll();

        for (Members members1 : allmembers) {
            if (members1.getEmail().equals(membersDTO.getEmail())) {
                modelmapper.map(members, members1);
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
