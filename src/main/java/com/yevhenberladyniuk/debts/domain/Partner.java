package com.yevhenberladyniuk.debts.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Partner {

    @Id
    private Long id;

    private Long userId;

    private String firstName;

    private String lastName;

    private double debt;

    private LocalDateTime date;
}
