package com.constructWeek3.assure;

import com.constructWeek3.assure.entity.Claim;
import com.constructWeek3.assure.entity.Members;
import com.constructWeek3.assure.entity.PolicyBookings;
import com.constructWeek3.assure.entity.User;
import com.constructWeek3.assure.repository.ClaimsRepository;
import com.constructWeek3.assure.repository.MembersRepository;
import com.constructWeek3.assure.repository.PolicyBookingsRepository;
import com.constructWeek3.assure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BootstrapData implements CommandLineRunner{
    @Autowired
    ClaimsRepository claimsRepository;

    @Autowired
    MembersRepository membersRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PolicyBookingsRepository policyBookingsRepository;
    @Override
    public void run(String... args) throws Exception {

        Members member = membersRepository.findById(1L).get();
        User user = userRepository.findById(1L).get();
        Claim claim = new Claim();
        claim.setClaimItem("Hospital Bills");
        claim.setAmountToClaim(20000.0f);
        claim.setAadharNumber(123456781234L);
        claim.setMember(member);
        claim.setUser(user);
        PolicyBookings policyBooked = policyBookingsRepository.findById(1L).get();
        claim.setPolicyBookings(policyBooked);
        claim.setDateOfTreatment(new Date());
        claim.setSubmissionDate(new Date());
        claim.setStatus("Processing");

        claimsRepository.save(claim);
    }
}
