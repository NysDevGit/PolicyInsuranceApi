package com.tinubu.exercice.insurance.dto;

import com.tinubu.exercice.insurance.model.Status;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PolicyInsuranceDto {
    private Integer identifier;
    private String name;
    private Status status;
    private LocalDateTime coverageStartingDate;
    private LocalDateTime coverageEndingDate;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
