package com.servise.CustomValidation;


import com.servise.AlbomFotoService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidNameAlbom  implements ConstraintValidator<CustomValidNameAlbom,String> {

    @Autowired
    AlbomFotoService albomFotoServiceImpl;

    public void initialize(CustomValidNameAlbom customValidNameAlbom) {

    }

    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (albomFotoServiceImpl == null){
            return true;
        }
        return albomFotoServiceImpl.findOneNameAlbom(s) == null;
    }
}
