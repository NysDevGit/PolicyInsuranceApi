package com.tinubu.exercice.insurance.mapper;

import com.tinubu.exercice.insurance.dto.PolicyInsuranceDto;
import com.tinubu.exercice.insurance.model.PolicyInsurance;
import org.springframework.stereotype.Component;

@Component
public class PolicyInsuranceMapper {

    public PolicyInsuranceDto toDto(PolicyInsurance policyInsurance) {
        PolicyInsuranceDto policyInsuranceDto = new PolicyInsuranceDto();
        policyInsuranceDto.setIdentifier(policyInsurance.getId());
        policyInsuranceDto.setName(policyInsurance.getName());
        policyInsuranceDto.setStatus(policyInsurance.getStatus());
        policyInsuranceDto.setCoverageStartingDate(policyInsurance.getCoverageStartingDate());
        policyInsuranceDto.setCoverageEndingDate(policyInsurance.getCoverageEndingDate());
        policyInsuranceDto.setCreatedOn(policyInsurance.getCreatedOn());
        policyInsuranceDto.setUpdatedOn(policyInsurance.getUpdatedOn());
        return policyInsuranceDto;
    }

    public PolicyInsurance toEntity(PolicyInsuranceDto policyInsuranceDto) {
        PolicyInsurance policyInsurance = new PolicyInsurance();
        policyInsurance.setName(policyInsuranceDto.getName());
        policyInsurance.setStatus(policyInsuranceDto.getStatus());
        policyInsurance.setCoverageStartingDate(policyInsuranceDto.getCoverageStartingDate());
        policyInsurance.setCoverageEndingDate(policyInsuranceDto.getCoverageEndingDate());
        return policyInsurance;
    }
}
