package com.smtown.itunes.itunesapi.api.response.genreidsappendix;

import java.io.Serializable;
import java.util.Map;

/**
 * Single entry in an iTunes {@link GenreIdsResponse}.
 */
public class Genre implements Serializable {

    private static final long serialVersionUID = 1501610118604L;

    private String name;
    private String id;
    private String url;
    private Map<String, String> rssUrls;
    private Map<String, String> chartUrls;
    private Map<Integer, Genre> subgenres;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getRssUrls() {
        return rssUrls;
    }

    public void setRssUrls(Map<String, String> rssUrls) {
        this.rssUrls = rssUrls;
    }

    public Map<String, String> getChartUrls() {
        return chartUrls;
    }

    public void setChartUrls(Map<String, String> chartUrls) {
        this.chartUrls = chartUrls;
    }

    public Map<Integer, Genre> getSubgenres() {
        return subgenres;
    }

    public void setSubgenres(Map<Integer, Genre> subgenres) {
        this.subgenres = subgenres;
    }
}
