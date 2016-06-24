package com.servise.CustomValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidNameAlbom.class)
public @interface CustomValidNameAlbom {

    String message() default "exception";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
