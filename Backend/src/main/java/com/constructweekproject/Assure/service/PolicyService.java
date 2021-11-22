package com.constructweekproject.Assure.service;

import com.constructweekproject.Assure.dto.PolicyDTO;
import com.constructweekproject.Assure.dto.AgeDTO;
import com.constructweekproject.Assure.entity.Location;
import com.constructweekproject.Assure.entity.Policy;
import com.constructweekproject.Assure.exception.InvalidAgeOfMemberException;
import com.constructweekproject.Assure.exception.PolicyDoesNotExistException;
import com.constructweekproject.Assure.exception.UserExists;
import com.constructweekproject.Assure.modelmapper.ModelMapperClass;
import com.constructweekproject.Assure.repository.LocationRepository;
import com.constructweekproject.Assure.repository.PolicyRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyService{

    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private ModelMapperClass modelMapper;

    protected Float ageToPremium(Policy policy, Integer age) {
        if (age == null || age == 0) return 0.0F;
        if (age < 18) return policy.getPremiumUpto18();
        if (age < 45) return policy.getPremiumUpto45();
        if (age < 60) return policy.getPremiumUpto60();
        if (age >= 60) return policy.getPremiumBeyond60();
        return 0.0F;
    }

    protected Boolean isAgeProvided(Integer age1, Integer age2) {
        return !(age1 == null || age1 == 0 || age2 == null || age2 == 0);
    }

    protected Boolean isAgeProvided(Integer age1) {
        return !(age1 == null || age1 == 0);
    }
    public List<PolicyDTO> getPolicies(AgeDTO ages) {

//        Long user = ages.getUserId();

        Integer ageSelf = ages.getAgeOfSelf();
        Integer ageFather = ages.getAgeOfFather();
        Integer ageMother = ages.getAgeOfMother();
        Integer ageSpouse = ages.getAgeOfSpouse();
        Integer ageSon = ages.getAgeOfSon();
        Integer ageDaughter = ages.getAgeOfDaughter();

        if ((isAgeProvided(ageFather) && ageFather < 0) || (isAgeProvided(ageSelf) && ageSelf < 0) || (isAgeProvided(ageMother) && ageMother < 0) || (isAgeProvided(ageDaughter) && ageDaughter < 0) || (isAgeProvided(ageSpouse) && ageSpouse < 0) || (isAgeProvided(ageSon) && ageSon < 0)) throw new InvalidAgeOfMemberException("Invalid age specification. Age cannot be negative.");
        if (isAgeProvided(ageFather, ageSelf) && (ageFather - ageSelf < 18)) throw new InvalidAgeOfMemberException("Invalid age specification. Your Father should be atleast 18 years elder than you.");
        if (isAgeProvided(ageMother, ageSelf) && (ageMother - ageSelf < 18)) throw new InvalidAgeOfMemberException("Invalid age specification. Your Mother should be atleast 18 years elder than you.");
        if (isAgeProvided(ageSon, ageSelf) && (ageSelf - ageSon < 18)) throw new InvalidAgeOfMemberException("Invalid age specification. Your Son should be atleast 18 years younger than you.");
        if (isAgeProvided(ageDaughter, ageSelf) && (ageSelf - ageDaughter < 18)) throw new InvalidAgeOfMemberException("Invalid age specification. Your Daughter should be atleast 18 years younger than you.");
        if (isAgeProvided(ageDaughter, ageSpouse) && (ageSpouse - ageDaughter < 18)) throw new InvalidAgeOfMemberException("Invalid age specification. Your Daughter should be atleast 18 years younger than your spouse.");
        if (isAgeProvided(ageSpouse, ageSon) && (ageSpouse - ageSon < 18)) throw new InvalidAgeOfMemberException("Invalid age specification. Your Son should be atleast 18 years younger than your spouse.");

        List<Policy> policies = policyRepository.findAll();
        List<PolicyDTO> policyDTOList = modelMapper.modelMapper().map(policies, new TypeToken<List<PolicyDTO>>() {}.getType());

        for (int i = 0; i < policies.size(); i++) {

            Policy policy = policies.get(i);

            Float premium = ageToPremium(policy, ageSelf);
            premium += ageToPremium(policy, ageFather);
            premium += ageToPremium(policy, ageMother);
            premium += ageToPremium(policy, ageSon);
            premium += ageToPremium(policy, ageDaughter);
            premium += ageToPremium(policy, ageSpouse);

            policyDTOList.get(i).setPremium1(premium);
            policyDTOList.get(i).setPremium2(premium * 1.2F);
            policyDTOList.get(i).setPremium3(premium * 1.4F);

        }
        return policyDTOList;

    }

    public String addLocatonForPolicy(Long policyId, Location location) {
        Optional<Policy> policy2 = policyRepository.findById(policyId);

        if(policy2.isEmpty()){
            throw new PolicyDoesNotExistException("The policy that you chose does not exist");
        }
        else {
            Policy policy = policyRepository.findById(policyId).get();
            Optional<Location> location2 = locationRepository.findById(location.getLocationId());
            if(location2.isEmpty()){
                locationRepository.save(location);
                policy.addLocation(location);
                location.addPolicies(policy);
                locationRepository.save(location);
                policyRepository.save(policy);
            }
            else{
                Location location1 = locationRepository.findById(location.getLocationId()).get();
                List<Policy> policies = location1.getPolicies();

                for(Policy policy1:policies){
                    if(policy1.getPolicyId()==policyId){
                        throw new UserExists("Location is already exist for the policy");
                    }
                }


                Location location3 = locationRepository.findById(location.getLocationId()).get();
                policy.addLocation(location3);
                location3.addPolicies(policy);
                locationRepository.save(location3);
                policyRepository.save(policy);

            }

            return "Location has been successfully added";
        }

    }
}
