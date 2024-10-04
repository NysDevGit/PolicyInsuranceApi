package com.tinubu.exercice.insurance.service;

import com.tinubu.exercice.insurance.dto.PolicyInsuranceDto;
import com.tinubu.exercice.insurance.exception.PolicyInsuranceNotFound;
import com.tinubu.exercice.insurance.exception.PolicyInsuranceUpdateFailed;
import com.tinubu.exercice.insurance.mapper.PolicyInsuranceMapper;
import com.tinubu.exercice.insurance.model.PolicyInsurance;
import com.tinubu.exercice.insurance.repository.PolicyInsuranceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PolicyInsuranceService implements IPolicyInsuranceService {

    private final PolicyInsuranceRepository policyInsuranceRepository;
    private final PolicyInsuranceMapper policyInsuranceMapper;

    @Override
    public PolicyInsuranceDto create(PolicyInsuranceDto policyInsuranceDto) {
        PolicyInsurance policyInsurance = policyInsuranceMapper.toEntity(policyInsuranceDto);
        return policyInsuranceMapper.toDto(policyInsuranceRepository.save(policyInsurance));
    }

    @Override
    public List<PolicyInsuranceDto> findPolicies() {
        return policyInsuranceRepository.findAll().stream()
                .map(policyInsuranceMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PolicyInsuranceDto findPolicy(Integer id) {
        return policyInsuranceRepository.findById(id)
                .map(policyInsuranceMapper::toDto)
                .orElseThrow(() -> new PolicyInsuranceNotFound("Policy Not Found"));
    }

    @Override
    public PolicyInsuranceDto update(Integer id, PolicyInsuranceDto policyInsuranceDto) {
        return policyInsuranceRepository.findById(id)
                .map(updatedPolicyInsurance -> {
                    updatedPolicyInsurance.setName(policyInsuranceDto.getName());
                    updatedPolicyInsurance.setStatus(policyInsuranceDto.getStatus());
                    updatedPolicyInsurance.setCoverageStartingDate(policyInsuranceDto.getCoverageStartingDate());
                    updatedPolicyInsurance.setCoverageEndingDate(policyInsuranceDto.getCoverageEndingDate());
                    PolicyInsurance savedPolicyInsurance = policyInsuranceRepository.save(updatedPolicyInsurance);
                    return policyInsuranceMapper.toDto(savedPolicyInsurance);
                }).orElseThrow(() -> new PolicyInsuranceUpdateFailed("Update Failed"));
    }
}
