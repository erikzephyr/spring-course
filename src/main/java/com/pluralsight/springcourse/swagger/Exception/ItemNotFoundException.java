package com.pluralsight.springcourse.swagger.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends Exception {

    public ItemNotFoundException(Long id) {
        super(MessageFormat.format("Item with id {0} not found in database", id));
    }
}
