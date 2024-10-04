package com.tinubu.exercice.insurance.service;

import com.tinubu.exercice.insurance.dto.PolicyInsuranceDto;

import java.util.List;

public interface IPolicyInsuranceService {

    PolicyInsuranceDto create(PolicyInsuranceDto policyInsuranceDto);

    List<PolicyInsuranceDto> findPolicies();

    PolicyInsuranceDto findPolicy(Integer id);

    PolicyInsuranceDto update(Integer id, PolicyInsuranceDto policyInsuranceDto);
}
