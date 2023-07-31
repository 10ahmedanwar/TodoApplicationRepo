package com.example.TodoApplication.error;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ValidationError {
    private List<String> errors=new ArrayList<>();
    private String url;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy  hh:mm:ss ")
    private Date timestamp;

    public ValidationError() {
        this.timestamp = new Date();
    }

    public void addError(String error)
    {
        errors.add(error);
    }
    public List<String> getErrors() {
        return errors;
    }

    public String getUrl() {
        return url;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
