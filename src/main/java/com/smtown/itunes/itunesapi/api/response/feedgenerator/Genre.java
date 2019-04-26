package com.smtown.itunes.itunesapi.api.response.feedgenerator;


import java.io.Serializable;

import com.smtown.itunes.itunesapi.api.response.genreidsappendix.GenreIdsResponse;

/**
 * Single entry in an iTunes {@link GenreIdsResponse}.
 */
public class Genre implements Serializable {

    private static final long serialVersionUID = 1501610118604L;

    private String genreId;
    private String name;
    private String url;

    public String getGenreId() {
        return genreId;
    }

    public void setGenreId(String genreId) {
        this.genreId = genreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Genre [genreId=")
                .append(genreId)
                .append(", name=")
                .append(name)
                .append(", url=")
                .append(url)
                .append("]")
                .toString();
    }

}
