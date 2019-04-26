package com.smtown.itunes.itunesapi.api.response.genreidsappendix;


import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;

import com.smtown.itunes.itunesapi.api.GenreIdsAppendix;

/**
 * iTunes Genre ID response
 */
public class GenreIdsResponse implements Serializable  {

    private static final long serialVersionUID = 1501610206217L;

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final MapType MAP_TYPE = MAPPER.getTypeFactory().constructMapType(HashMap.class, Integer.class, Genre.class);

    private final Map<Integer, Genre> genres = new HashMap<>();

    /**
     * Static factory for parsing a valid JSON response to a new
     * {@link GenreIdsResponse} instance
     *
     * @param json
     *            the JSON response received from Apple's Genre IDs Appendix API
     * @return a {@link GenreIdsAppendix} instance
     * @throws IllegalArgumentException if argument null
     * @throws IOException on exception with parsing JSON
     */
    public static GenreIdsResponse parse(String json) throws IOException {
        if (json == null) {
            throw new IllegalArgumentException("json argument can not be null");
        }
        Map<Integer, Genre> map = MAPPER.readValue(json, MAP_TYPE);
        GenreIdsResponse response = new GenreIdsResponse();
        response.genres.putAll(map);
        return response;
    }

    /**
     * @return modifiable {@link Map} containing the parsed genres in this response
     */
    public Map<Integer, Genre> getGenres() {
        return genres;
    }

    @Override
    public String toString() {
        return "GenreIdsResponse[" + genres + "]";
    }

}
