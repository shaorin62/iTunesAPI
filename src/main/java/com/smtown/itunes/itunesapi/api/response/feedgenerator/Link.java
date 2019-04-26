package com.smtown.itunes.itunesapi.api.response.feedgenerator;


import java.io.IOException;
import java.io.Serializable;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.smtown.itunes.itunesapi.api.response.feedgenerator.Link.LinkDeserializer;

/**
 * Single link in an iTunes {@link Feed}.
 */
@JsonDeserialize(using = LinkDeserializer.class)
public class Link implements Serializable {

    private static final long serialVersionUID = 1501415268127L;

    public Link() {

    }

    public Link(String type, String uri) {
        this.type = type;
        this.uri = uri;
    }

    private String type;
    private String uri;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
                .append("Link [type=")
                .append(type)
                .append(", uri=")
                .append(uri)
                .append("]")
                .toString();
    }

    public static class LinkDeserializer extends JsonDeserializer<Link> {

        @Override
        public Link deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            JsonNode node = p.getCodec().readTree(p);
            Entry<String, JsonNode> entry = node.fields().next();
            return new Link(entry.getKey(), entry.getValue().asText());
        }

    }
}
