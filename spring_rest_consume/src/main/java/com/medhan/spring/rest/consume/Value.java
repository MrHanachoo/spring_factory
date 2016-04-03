package com.medhan.spring.rest.consume;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by mhan on 3/15/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {

    private long id;
    private String quote;

    public Value() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "Quote{" + "type='" + id + "\'" + ", value=" + quote + "}";
    }
}
