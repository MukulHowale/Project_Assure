package com.constructweekproject.Assure.repository;


import com.constructweekproject.Assure.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {

}
