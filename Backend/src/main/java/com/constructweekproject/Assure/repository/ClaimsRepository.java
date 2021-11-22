package com.constructweekproject.Assure.repository;

import com.constructweekproject.Assure.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimsRepository extends JpaRepository<Claim, Long> {
}
