package com.smtown.itunes.itunesapi.api;

import java.io.IOException;
import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.smtown.itunes.itunesapi.api.http.Connector;
import com.smtown.itunes.itunesapi.api.http.URLConnector;
import com.smtown.itunes.itunesapi.api.response.genreidsappendix.GenreIdsResponse;

/**
 * Implementation of the Genre IDs Appendix API.
 *
 * @see <a href="https://affiliate.itunes.apple.com/resources/documentation/genre-mapping/">Genre ID API</a>
 */
public class GenreIdsAppendix implements Serializable  {

    private static final Logger logger = LoggerFactory.getLogger(GenreIdsAppendix.class);

    private static final long serialVersionUID = 1501610161047L;

    private static final String API_ENDPOINT = "https://itunes.apple.com/WebObjects/MZStoreServices.woa/ws/genres";

    /**
     * Execute this Genre IDs Appendix request.
     *
     * @return parsed {@link GenreIdsResponse} from iTunes
     * @throws RuntimeException
     *             wrapping any {@link IOException} thrown performing the
     *             request or parsing the response
     */
    public GenreIdsResponse execute() {
        return execute(URLConnector.INSTANCE);
    }

    /**
     * Execute this Genre IDs Appendix request using the provided
     * {@link Connector} implementation.
     *
     * @param connector
     *            {@link Connector} implementation, not {@code null}
     * @return parsed {@link GenreIdsResponse} response from iTunes
     * @throws IllegalArgumentException
     *             if argument {@code null}
     * @throws RuntimeException
     *             wrapping any {@link IOException} thrown performing the
     *             request or parsing the response
     */
    public GenreIdsResponse execute(Connector connector) {
        if (connector == null) {
            throw new IllegalArgumentException("connector can not be null");
        }
        try {
            String response = connector.get(API_ENDPOINT);
            logger.trace("{} -> {}", API_ENDPOINT, response);
            return GenreIdsResponse.parse(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
