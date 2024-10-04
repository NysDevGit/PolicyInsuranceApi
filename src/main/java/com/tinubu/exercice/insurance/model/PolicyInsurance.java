package com.tinubu.exercice.insurance.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotBlank;


import java.time.LocalDateTime;

@Entity
@Table(name = "policy_insurance")
@NoArgsConstructor
@Getter
@Setter
public class PolicyInsurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "name is mandatory")
    private String name;
    @NotNull
    private Status status;
    @NotNull
    private LocalDateTime coverageStartingDate;
    @NotNull
    private LocalDateTime coverageEndingDate;
    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;

}
