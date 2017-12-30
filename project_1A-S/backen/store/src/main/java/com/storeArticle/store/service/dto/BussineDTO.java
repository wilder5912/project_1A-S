package com.storeArticle.store.service.dto;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


public class BussineDTO implements Serializable {

    private String value;

    private String label;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}

