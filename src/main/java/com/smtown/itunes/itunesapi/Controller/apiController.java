package com.smtown.itunes.itunesapi.Controller;

import com.smtown.itunes.itunesapi.api.FeedGenerator;
import com.smtown.itunes.itunesapi.api.Lookup;
import com.smtown.itunes.itunesapi.api.Search;
import com.smtown.itunes.itunesapi.api.request.Entity;
import com.smtown.itunes.itunesapi.api.request.Country;
import com.smtown.itunes.itunesapi.api.request.feedgenerator.FeedType;
import com.smtown.itunes.itunesapi.api.request.feedgenerator.MediaType;
import com.smtown.itunes.itunesapi.api.request.search.Attribute;
import com.smtown.itunes.itunesapi.api.request.search.Media;
import com.smtown.itunes.itunesapi.api.response.Response;

import com.smtown.itunes.itunesapi.api.response.feedgenerator.Feed;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class apiController {

    @RequestMapping("/")
    public String apiCall(Model model){

        model.addAttribute("name","Springboot Hello");
        return "index";
    }

    @RequestMapping("/search")
    public String search(){

        Response searchResponse = new Search("cbs radio")
                .setCountry(Country.CANADA)
                .setAttribute(Attribute.AUTHOR_TERM)
                .setMedia(Media.MUSIC)
                .setLimit(1)
                .execute();

        System.out.println("search ==>" + searchResponse);

        System.out.println("search ==>" + searchResponse);

        String returnvalue1 = searchResponse.toString();

        return returnvalue1;
    }

    @RequestMapping("/lookup")
    public String loookup(){
        Response lookupResponse = new Lookup()
                .addId("178834")
                .setEntity(Entity.ALBUM)
                .execute();

        System.out.println("lookup ==>" + lookupResponse);

        String returnvalue = lookupResponse.toString();

        return returnvalue;
    }

    @RequestMapping("/feedGenerator")
    public String feedGenerator(){
        String responseUrl = new FeedGenerator()
                .setCountry(Country.FRANCE)
                .setMediaType(MediaType.APPLE_MUSIC)
                .setFeedType(FeedType.HOT_ALBUMS)
                .setResultsLimit(10)
                .getUrl();

        Feed responseFeed = new FeedGenerator()
                .setAllowExplicit(true)
                .setCountry(Country.FRANCE)
                .setMediaType(MediaType.APPLE_MUSIC)
                .setFeedType(FeedType.HOT_ALBUMS)
                .setResultsLimit(10)
                .execute();

        System.out.println("responseUrl ==>" + responseUrl);
        System.out.println("responseFeed ==>" + responseFeed);


        return responseUrl;
    }

}
