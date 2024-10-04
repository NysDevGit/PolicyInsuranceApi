package com.tinubu.exercice.insurance.controller;

import com.tinubu.exercice.insurance.dto.PolicyInsuranceDto;
import com.tinubu.exercice.insurance.service.PolicyInsuranceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insurance/policy")
@AllArgsConstructor
public class PolicyInsuranceController {

    private final PolicyInsuranceService policyInsuranceService;

    @PostMapping("/create")
    public ResponseEntity<PolicyInsuranceDto> create(@RequestBody PolicyInsuranceDto policyInsurance) {

        PolicyInsuranceDto policyInsuranceDto = policyInsuranceService.create(policyInsurance);
        return new ResponseEntity<>(policyInsuranceDto, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PolicyInsuranceDto> retrievePolicy(@PathVariable Integer id) {
        PolicyInsuranceDto policyInsuranceDto = policyInsuranceService.findPolicy(id);
        return new ResponseEntity<>(policyInsuranceDto, HttpStatus.OK);

    }

    @GetMapping("/getPolicies")
    public ResponseEntity<List<PolicyInsuranceDto>> retrievePolicies() {
        List<PolicyInsuranceDto> policiesInsuranceDto = policyInsuranceService.findPolicies();
        return new ResponseEntity<>(policiesInsuranceDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PolicyInsuranceDto>  updatePolicy(@PathVariable Integer id, @RequestBody PolicyInsuranceDto policyInsuranceDto) {
        PolicyInsuranceDto updatedPolicyInsurance = policyInsuranceService.update(id, policyInsuranceDto);
        return new ResponseEntity<>(updatedPolicyInsurance, HttpStatus.OK);
    }
}
