package com.smtown.itunes.itunesapi.api.request.lookup;


import java.util.Locale;

/**
 * Sort order for results in an iTunes response.
 */
public enum Sort {
    POPULAR,
    RECENT;

    private final String string;

    private Sort() {
        this.string = name().toLowerCase(Locale.ENGLISH);
    }

    public String toString() {
        return this.string;
    }
}
