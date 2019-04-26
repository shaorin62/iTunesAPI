package com.smtown.itunes.itunesapi.api.request.feedgenerator;

public enum FeedFormat {

    JSON,
    XML;

    private final String code;
    private FeedFormat() {
        this.code = name().toLowerCase();
    }

    public String getCode() {
        return code;
    }
}
