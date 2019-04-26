package com.smtown.itunes.itunesapi.api.response.feedgenerator;

import java.io.Serializable;
/**
 * Author of an iTunes {@link Feed}.
 */
public class Author implements Serializable {

    private static final long serialVersionUID = 1501415280761L;

    private String name;
    private String uri;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Author [name=")
                .append(name)
                .append(", uri=")
                .append(uri)
                .append("]")
                .toString();
    }
}
