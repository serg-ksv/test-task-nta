package com.ksv.springboottask.model.dto;

import com.ksv.springboottask.validator.PasswordsMatch;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@PasswordsMatch
public class UserRequestDto {
    @Size(min = 4, max = 20)
    private String login;
    @NotBlank(message = "Password can't be empty!")
    private String password;
    @NotBlank(message = "repeatPassword can't be empty!")
    private String repeatPassword;
}
