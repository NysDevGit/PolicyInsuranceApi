package com.tinubu.exercice.insurance.repository;

import com.tinubu.exercice.insurance.model.PolicyInsurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyInsuranceRepository extends JpaRepository<PolicyInsurance, Integer> {
}
