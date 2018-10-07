package com.storeArticle.store.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ObjectNotFoundException  extends RuntimeException{
    public ObjectNotFoundException(String exception) {
        super(exception);
    }
}
