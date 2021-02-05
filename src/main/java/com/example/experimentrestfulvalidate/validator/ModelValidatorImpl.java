package com.example.experimentrestfulvalidate.validator;

import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import com.example.experimentrestfulvalidate.exceptions.InvalidModelException;
import lombok.RequiredArgsConstructor;

/**
 * Model Validator Implementation
 *
 */
@RequiredArgsConstructor
public class ModelValidatorImpl implements ModelValidator {

    private final Validator validator;


    @Override
    public void validate(Object object, Class<?>... groups) {
        Set<ConstraintViolation<Object>> violations = validator.validate(object, groups);
        if (violations.isEmpty() == false) {
            String message = violations.stream()
                    .sorted(Comparator.comparing(v -> v.getPropertyPath().toString()))
                    .map(v -> v.getPropertyPath() + ":" + v.getMessage())
                    .collect(Collectors.joining(","));
            throw new InvalidModelException(message);
        }
    }
}