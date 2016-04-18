package com.servise.CustomValidation;


import com.servise.AlbomFotoService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidNameAlbom  implements ConstraintValidator<CustomValidNameAlbom,String>{

    @Autowired
    AlbomFotoService albomFotoService;

    public void initialize(CustomValidNameAlbom customValidNameAlbom) {

    }

    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (albomFotoService == null){
            return true;
        }
        return albomFotoService.findOneNameAlbom(s) == null;
    }
}
