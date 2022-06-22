package com.fmi.merchandise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private Long id;

    @Size(max = 50)
    @Pattern(regexp = "^[a-zA-Z .!,?-]*$]")
    @NotBlank
    private String content;

    @NotNull
    @Positive
    private Long itemId;

    @Size(max = 16, min = 3)
    @Pattern(regexp = "^[a-zA-Z0-9_-]*$")
    @NotBlank
    private String username;
}
