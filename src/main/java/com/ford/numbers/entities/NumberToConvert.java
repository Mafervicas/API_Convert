package com.ford.numbers.entities;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NumberToConvert {
    @NotNull
    String numberUser;
}
