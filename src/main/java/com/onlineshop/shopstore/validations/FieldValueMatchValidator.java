package com.onlineshop.shopstore.validations;

import com.onlineshop.shopstore.annotations.FieldsValueMatch;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class FieldValueMatchValidator implements ConstraintValidator<FieldsValueMatch, Object> {

    private String field;
    private String fieldMatch;

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Object fieldValue = new BeanWrapperImpl(o).getPropertyValue(field);
        Object fieldMatchValue = new BeanWrapperImpl(o).getPropertyValue(fieldMatch);
        if (fieldValue != null) {
            return fieldValue.equals(fieldMatchValue);
        } else {
            return fieldMatchValue == null;
        }
//        if (fieldValue != null) {
//            if (fieldValue.toString().startsWith("$2a")){
//                return true;
//            } else {
//                return fieldValue.equals(fieldMatchValue);
//            }
        }

    @Override
    public void initialize(FieldsValueMatch constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.fieldMatch = constraintAnnotation.fieldMatch();
    }
}
