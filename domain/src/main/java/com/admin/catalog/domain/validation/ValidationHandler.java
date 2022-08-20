package com.admin.catalog.domain.validation;

import java.util.List;

public interface ValidationHandler {

    ValidationHandler append(final Error error);

    ValidationHandler append(ValidationHandler handler);

    ValidationHandler validate(Validation validation);

    default boolean hasError(){
        return getErrors() != null && !(getErrors().isEmpty());
    }

    List<Error> getErrors();

    public interface Validation{
        void validate();
    }


}
