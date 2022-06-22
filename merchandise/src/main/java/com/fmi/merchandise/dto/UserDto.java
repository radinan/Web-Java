package com.fmi.merchandise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;

    @Size(max = 16, min = 3)
    @Pattern(regexp = "^[a-zA-Z0-9_-]*$")
    @NotBlank
    private String username;

    @Size(max = 16, min = 5)
    @Pattern(regexp = "^[a-zA-Z0-9_@*-]*$")
    @NotBlank
    private String password;

    @Email
    private String email;

    @Pattern(regexp = "^[a-zA-Z ]*$")
    private String firstName;

    @Pattern(regexp = "^[a-zA-Z ]*$")
    private String lastName;

    @Pattern(regexp = "^[0-9]*$")
    private String phoneNumber;
}
