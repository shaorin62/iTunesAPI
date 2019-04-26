package com.smtown.itunes.itunesapi.api.http;

import java.io.IOException;

/**
 * Interface wrapping HTTP connection logic
 *
 * @see URLConnector
 */

public interface Connector {

    /**
     * Perform an HTTP request. Return the response body as {@link String}.
     *
     * @param link
     *            a full link, including scheme
     * @return server response body as {@link String}, never {@code null}
     * @throws IOException
     *             if a problem occurred with the connection
     */
    public String get(String link) throws IOException;
}
