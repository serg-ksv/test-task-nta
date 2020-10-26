package com.ksv.springboottask.validator;

import com.ksv.springboottask.model.dto.UserRequestDto;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordsMatchValidator implements
        ConstraintValidator<PasswordsMatch, UserRequestDto> {

    @Override
    public boolean isValid(UserRequestDto requestDto, ConstraintValidatorContext context) {
        return requestDto.getPassword().equals(requestDto.getRepeatPassword());
    }
}
