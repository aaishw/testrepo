package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExceptionHandling extends  RuntimeException{
    private String resource;
    private String field;
    private Object objectname;

    public String getResource() {
        return resource;
    }

    public String getField() {
        return field;
    }

    public Object getObjectname() {
        return objectname;
    }

    public ExceptionHandling(String resource, String field, Object objectname) {
        super(String.format("Error: ID Not found", resource, field, objectname));

        this.resource = resource;
        this.field = field;
        this.objectname = objectname;
    }
}
