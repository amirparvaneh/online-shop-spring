package com.onlineshop.shopstore.annotations;

import com.onlineshop.shopstore.validations.PasswordStrengthValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordStrengthValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordValidator {

    String message() default "Fields values does not match!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
