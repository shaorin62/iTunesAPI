package com.smtown.itunes.itunesapi.api.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

/**
 * Default {@link Connector} implementation using {@link URLConnection}.
 */
public class URLConnector implements Connector, Serializable  {
    private static final long serialVersionUID = 1476515538667L;

    /**
     * Reusable, threadsafe {@link URLConnector} instance.
     */
    public static final URLConnector INSTANCE = new URLConnector();

    /**
     * {@inheritDoc}
     *
     * @throws MalformedURLException as thrown by {@link URL#URL(String)}
     */
    public String get(String link) throws IOException {
        URL url = new URL(link);
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openConnection().getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            return sb.toString().trim();
        }
    }

}
