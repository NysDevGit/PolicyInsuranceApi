package com.tinubu.exercice.insurance;

import com.tinubu.exercice.insurance.dto.PolicyInsuranceDto;
import com.tinubu.exercice.insurance.model.PolicyInsurance;
import com.tinubu.exercice.insurance.model.Status;

import java.time.LocalDateTime;
import java.util.List;

public class PolicyUtilities {

    public static final String FIRST_POLICY = "First Policy";

    public static PolicyInsurance createPolicy() {
        PolicyInsurance policyInsurance = new PolicyInsurance();
        policyInsurance.setId(1);
        policyInsurance.setName(FIRST_POLICY);
        policyInsurance.setStatus(Status.ACTIVE);
        policyInsurance.setCreatedOn(LocalDateTime.now());
        policyInsurance.setUpdatedOn(LocalDateTime.now());
        policyInsurance.setCoverageStartingDate(LocalDateTime.now());
        policyInsurance.setCoverageEndingDate(LocalDateTime.now());
        return policyInsurance;
    }

    public static PolicyInsuranceDto createPolicyDto() {
        PolicyInsuranceDto policyInsuranceDto = new PolicyInsuranceDto();
        policyInsuranceDto.setName(FIRST_POLICY);
        policyInsuranceDto.setStatus(Status.INACTIVE);
        policyInsuranceDto.setCoverageStartingDate(LocalDateTime.now());
        policyInsuranceDto.setCoverageEndingDate(LocalDateTime.now());
        return policyInsuranceDto;
    }

    public static PolicyInsurance createUpdatedPolicy() {
        PolicyInsurance policyInsurance = new PolicyInsurance();
        policyInsurance.setId(3);
        policyInsurance.setName("Updated Policy");
        policyInsurance.setStatus(Status.ACTIVE);
        policyInsurance.setCreatedOn(LocalDateTime.now());
        policyInsurance.setUpdatedOn(LocalDateTime.now());
        policyInsurance.setCoverageStartingDate(LocalDateTime.now());
        policyInsurance.setCoverageEndingDate(LocalDateTime.now());
        return policyInsurance;
    }

    public static List<PolicyInsurance> createPolicies() {
        PolicyInsurance policyInsurance = new PolicyInsurance();
        policyInsurance.setId(1);
        policyInsurance.setName(FIRST_POLICY);
        policyInsurance.setStatus(Status.ACTIVE);
        policyInsurance.setCreatedOn(LocalDateTime.now());
        policyInsurance.setUpdatedOn(LocalDateTime.now());
        policyInsurance.setCoverageStartingDate(LocalDateTime.now());
        policyInsurance.setCoverageEndingDate(LocalDateTime.now());

        PolicyInsurance policyInsurance2 = new PolicyInsurance();
        policyInsurance2.setId(2);
        policyInsurance2.setName("Second Policy");
        policyInsurance2.setStatus(Status.INACTIVE);
        policyInsurance2.setCreatedOn(LocalDateTime.now());
        policyInsurance2.setUpdatedOn(LocalDateTime.now());
        policyInsurance2.setCoverageStartingDate(LocalDateTime.now());
        policyInsurance2.setCoverageEndingDate(LocalDateTime.now());

        return List.of(policyInsurance, policyInsurance2);
    }
}
