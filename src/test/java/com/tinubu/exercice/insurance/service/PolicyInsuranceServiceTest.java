package com.tinubu.exercice.insurance.service;

import com.tinubu.exercice.insurance.dto.PolicyInsuranceDto;
import com.tinubu.exercice.insurance.exception.PolicyInsuranceNotFound;
import com.tinubu.exercice.insurance.exception.PolicyInsuranceUpdateFailed;
import com.tinubu.exercice.insurance.mapper.PolicyInsuranceMapper;
import com.tinubu.exercice.insurance.model.PolicyInsurance;
import com.tinubu.exercice.insurance.model.Status;
import com.tinubu.exercice.insurance.repository.PolicyInsuranceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.tinubu.exercice.insurance.PolicyUtilities.*;

@ExtendWith(MockitoExtension.class)
public class PolicyInsuranceServiceTest {

    @Mock
    private PolicyInsuranceRepository policyInsuranceRepository;
    @Mock
    private PolicyInsuranceMapper policyInsuranceMapper;
    @InjectMocks
    private PolicyInsuranceService policyInsuranceService;

    @Test
    public void should_return_new_policy_when_created() {
        Mockito.when(policyInsuranceRepository.save(Mockito.any(PolicyInsurance.class)))
                .thenReturn(createPolicy());
        Mockito.when(policyInsuranceMapper.toEntity(Mockito.any(PolicyInsuranceDto.class))).
                thenReturn(createPolicy());
        Mockito.when(policyInsuranceMapper.toDto(Mockito.any(PolicyInsurance.class))).
                thenCallRealMethod();

        var newPolicy = policyInsuranceService.create(new PolicyInsuranceDto());

        Assertions.assertNotNull(newPolicy);
        Assertions.assertEquals(1, newPolicy.getIdentifier());
        Assertions.assertEquals("First Policy", newPolicy.getName());
        Assertions.assertEquals(Status.ACTIVE, newPolicy.getStatus());
    }

    @Test
    public void should_return_specific_policy() {
        Mockito.when(policyInsuranceRepository.findById(Mockito.any(Integer.class)))
                .thenReturn(Optional.of(createPolicy()));
        Mockito.when(policyInsuranceMapper.toDto(Mockito.any(PolicyInsurance.class))).
                thenCallRealMethod();

        var policy = policyInsuranceService.findPolicy(1);

        Assertions.assertNotNull(policy);
        Assertions.assertEquals(1, policy.getIdentifier());
        Assertions.assertEquals("First Policy", policy.getName());
        Assertions.assertEquals(Status.ACTIVE, policy.getStatus());
    }

    @Test
    public void should_throw_not_found_exception_when_policy_not_exists() {
        Mockito.when(policyInsuranceRepository.findById(Mockito.any(Integer.class)))
                .thenReturn(Optional.empty());

        PolicyInsuranceNotFound thrown = Assertions.assertThrows(PolicyInsuranceNotFound.class,
                () -> policyInsuranceService.findPolicy(1), "Policy Not Found");

        Assertions.assertNotNull(thrown);
    }

    @Test
    public void should_return_all_policies() {
        Mockito.when(policyInsuranceRepository.findAll())
                .thenReturn(createPolicies());
        Mockito.when(policyInsuranceMapper.toDto(Mockito.any(PolicyInsurance.class))).
                thenCallRealMethod();

        var policies = policyInsuranceService.findPolicies();

        Assertions.assertEquals(2, policies.size());
        Assertions.assertEquals("First Policy", policies.get(0).getName());
        Assertions.assertEquals("Second Policy", policies.get(1).getName());
    }

    @Test
    public void should_return_update_fail_exception_when_policy_not_exists() {
        Mockito.when(policyInsuranceRepository.findById(Mockito.any(Integer.class)))
                .thenReturn(Optional.empty());

        PolicyInsuranceUpdateFailed thrown = Assertions.assertThrows(PolicyInsuranceUpdateFailed.class,
                () -> policyInsuranceService.update(1, createPolicyDto()), "Update Failed");

        Assertions.assertNotNull(thrown);
    }


    @Test
    public void should_return_updated_policy() {
        Mockito.when(policyInsuranceRepository.findById(Mockito.any(Integer.class)))
                .thenReturn(Optional.of(createPolicy()));
        Mockito.when(policyInsuranceRepository.save(Mockito.any(PolicyInsurance.class)))
                .thenReturn(createUpdatedPolicy());
        Mockito.when(policyInsuranceMapper.toDto(Mockito.any(PolicyInsurance.class))).
                thenCallRealMethod();

        var updatedPolicy = policyInsuranceService.update(1, createPolicyDto());

        Assertions.assertNotNull(updatedPolicy);
        Assertions.assertEquals(3, updatedPolicy.getIdentifier());
        Assertions.assertEquals("Updated Policy", updatedPolicy.getName());
        Assertions.assertEquals(Status.ACTIVE, updatedPolicy.getStatus());
    }

}
