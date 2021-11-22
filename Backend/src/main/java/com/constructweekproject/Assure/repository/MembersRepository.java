package com.constructweekproject.Assure.repository;

import com.constructweekproject.Assure.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembersRepository extends JpaRepository<Members,Long> {

}
