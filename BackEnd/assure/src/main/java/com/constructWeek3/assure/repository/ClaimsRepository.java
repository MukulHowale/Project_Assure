package com.constructWeek3.assure.repository;

import com.constructWeek3.assure.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimsRepository extends JpaRepository<Claim, Long> {
}
