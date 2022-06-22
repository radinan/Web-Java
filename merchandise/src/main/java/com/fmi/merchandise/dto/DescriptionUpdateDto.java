package com.fmi.merchandise.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class DescriptionUpdateDto {
    @Size(max = 50)
    @Pattern(regexp = "^[a-zA-Z .!,?-]*$]")
    @NotBlank
    private String description;
}
