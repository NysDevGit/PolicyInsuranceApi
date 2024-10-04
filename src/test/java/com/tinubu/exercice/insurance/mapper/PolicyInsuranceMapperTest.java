package com.tinubu.exercice.insurance.mapper;

import com.tinubu.exercice.insurance.dto.PolicyInsuranceDto;
import com.tinubu.exercice.insurance.model.PolicyInsurance;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.tinubu.exercice.insurance.PolicyUtilities.createPolicy;
import static com.tinubu.exercice.insurance.PolicyUtilities.createPolicyDto;

@ExtendWith(MockitoExtension.class)
public class PolicyInsuranceMapperTest {

    PolicyInsuranceMapper policyInsuranceMapper = new PolicyInsuranceMapper();

    @Test
    public void should_convert_dto_to_entity(){
        PolicyInsuranceDto policyInsuranceDto = createPolicyDto();

        PolicyInsurance policyInsurance = policyInsuranceMapper.toEntity(policyInsuranceDto);

        Assertions.assertEquals(policyInsuranceDto.getName(), policyInsurance.getName());
        Assertions.assertEquals(policyInsuranceDto.getStatus(), policyInsurance.getStatus());
        Assertions.assertEquals(policyInsuranceDto.getCoverageStartingDate(), policyInsurance.getCoverageStartingDate());
        Assertions.assertEquals(policyInsuranceDto.getCoverageEndingDate(), policyInsurance.getCoverageEndingDate());
    }

    @Test
    public void should_convert_entity_to_dto(){
        PolicyInsurance policyInsurance = createPolicy();

        PolicyInsuranceDto policyInsuranceDto = policyInsuranceMapper.toDto(policyInsurance);

        Assertions.assertEquals(policyInsurance.getId(), policyInsuranceDto.getIdentifier());
        Assertions.assertEquals(policyInsurance.getName(), policyInsuranceDto.getName());
        Assertions.assertEquals(policyInsurance.getStatus(), policyInsuranceDto.getStatus());
        Assertions.assertEquals(policyInsurance.getCoverageStartingDate(), policyInsuranceDto.getCoverageStartingDate());
        Assertions.assertEquals(policyInsurance.getCoverageEndingDate(), policyInsuranceDto.getCoverageEndingDate());
        Assertions.assertEquals(policyInsurance.getCreatedOn(), policyInsuranceDto.getCreatedOn());
        Assertions.assertEquals(policyInsurance.getUpdatedOn(), policyInsuranceDto.getUpdatedOn());
    }
}
