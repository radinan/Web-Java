package com.fmi.merchandise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    private Long id;

    @Size(max = 50)
    @Pattern(regexp = "^[a-zA-Z _-]*$]")
    @NotBlank
    private String name;

    @Size(max = 50)
    @Pattern(regexp = "^[a-zA-Z .!,?-]*$]")
    @NotBlank
    private String description;

    private String category;

    @Positive
    private Double price;

    private String picture;
}
