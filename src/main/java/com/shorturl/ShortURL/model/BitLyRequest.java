package com.shorturl.ShortURL.model;

import lombok.Data;

@Data
public class BitLyRequest {
    public String getLongURL() {
        return longURL;
    }

    public void setLongURL(String longURL) {
        this.longURL = longURL;
    }

    private String longURL;
}

