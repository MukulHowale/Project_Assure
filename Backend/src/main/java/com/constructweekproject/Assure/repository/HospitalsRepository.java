package com.constructweekproject.Assure.repository;

import com.constructweekproject.Assure.entity.Hospitals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalsRepository extends JpaRepository<Hospitals, Long> {
    
}
