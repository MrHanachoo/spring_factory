package com.medhan.spring.rest.consume;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by mhan on 3/15/16.
 */

@JsonIgnoreProperties
public class Quote {

    private String type;
    private Value value;

    public Quote() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Quote{" + "type='" + type + "\'" + ", value=" + value + "}";
    }
}
