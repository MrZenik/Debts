package com.yevhenberladyniuk.debts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFormDto {

    private String username;

    private String password;
}
