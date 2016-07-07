package com.servise.CustomValidation;

import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidationEmailUser implements ConstraintValidator<CustomValidationEmailUser,String> {


    @Autowired
    private UserRepository userRepository;


    public void initialize(CustomValidationEmailUser customValidationEmailUser) {

    }

    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (userRepository == null){
            return true;
        }
        return userRepository.findOneByEMail(s) == null;
    }
}
