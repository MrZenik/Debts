package com.yevhenberladyniuk.debts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePartnerForm {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private double debt;

}
