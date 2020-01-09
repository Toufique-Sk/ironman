package com.interviewbit.ironman.core.repository;

import com.interviewbit.ironman.core.models.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<UserDetails, String> {
}
