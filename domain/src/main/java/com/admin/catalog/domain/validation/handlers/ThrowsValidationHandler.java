package com.admin.catalog.domain.validation.handlers;

import com.admin.catalog.domain.exceptions.DomainException;
import com.admin.catalog.domain.validation.Error;
import com.admin.catalog.domain.validation.ValidationHandler;

import java.util.List;

public class ThrowsValidationHandler implements ValidationHandler {
    @Override
    public ValidationHandler append(Error error) {
        throw DomainException.with(error);
    }

    @Override
    public ValidationHandler append(ValidationHandler handler) {
        throw DomainException.with(handler.getErrors());
    }

    @Override
    public ValidationHandler validate(final Validation validation) {
        try{
            validation.validate();
        }catch (final Exception ex){
            throw DomainException.with((new Error(ex.getMessage())));
        }
        return this;
    }

    @Override
    public boolean hasError() {
        return false;
    }

    @Override
    public List<Error> getErrors() {
        return null;
    }
}
