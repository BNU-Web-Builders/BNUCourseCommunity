package com.example.coursecommunity.repository;

import com.example.coursecommunity.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
