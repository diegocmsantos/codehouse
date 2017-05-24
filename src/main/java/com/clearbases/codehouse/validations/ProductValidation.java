package com.clearbases.codehouse.validations;

import com.clearbases.codehouse.models.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Product Validation
 * Created by Diego Maia on 24/05/17.
 */
public class ProductValidation implements Validator {

    public void isValid(Product product, Errors errors) {



    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Product product = (Product) o;

        ValidationUtils.rejectIfEmpty(errors, "title", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "description", "field.required");

        if (product.getPages() <= 0) {
            errors.rejectValue("pages", "field.required");
        }
    }
}
