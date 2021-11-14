package com.constructWeek3.assure.repository;

import com.constructWeek3.assure.entity.PolicyBookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyBookingsRepository extends JpaRepository<PolicyBookings, Long> {
}
