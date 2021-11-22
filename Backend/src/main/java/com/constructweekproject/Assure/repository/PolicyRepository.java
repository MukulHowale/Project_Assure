package com.constructweekproject.Assure.repository;

import com.constructweekproject.Assure.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {
}
