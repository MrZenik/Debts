package com.yevhenberladyniuk.debts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartnerDto {

    @Id
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

}
