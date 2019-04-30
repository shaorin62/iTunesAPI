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

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Controller
public class apiController {

    @RequestMapping("/")
    public String apiCall(Model model){

        model.addAttribute("name","Springboot Hello");
        return "index";
    }

    @RequestMapping("/search")
    public String search(Model model){

        List<Map<String, String>> resultList = new ArrayList<>(); //결과 정보 List


        Response jsonResponse = new Search("방탄소년단")
                .setCountry(Country.SOUTH_KOREA)
                .setMedia(Media.MUSIC)
                .setEntity(Entity.MUSIC_TRACK)
                .setLimit(2)
                .execute();

        for(int i = 0; i < jsonResponse.getResultCount(); i++) {
/*
            System.out.println("search ==>"  + jsonResponse.getResults().get(0));
            System.out.println("search2 ==>"  + jsonResponse.getResults().get(1));*/

            Map<String,String> map = new HashMap<>();

            map.put("artistName",jsonResponse.getResults().get(i).getArtistName());                 //아티스트 이름
            map.put("collectionName",jsonResponse.getResults().get(i).getCollectionName());         //앨범이름
            map.put("trackName",jsonResponse.getResults().get(i).getTrackName());                   //음악이름
            map.put("artistViewUrl",jsonResponse.getResults().get(i).getArtistViewUrl());           //아이튠스내 아티스트소개
            map.put("collectionViewUrl",jsonResponse.getResults().get(i).getCollectionViewUrl());   //아이튠스내 앨범소개 url
            map.put("artworkUrl30",jsonResponse.getResults().get(i).getArtworkUrl30());             //앨범사진 30*30
            map.put("previewUrl",jsonResponse.getResults().get(i).getPreviewUrl());                 //아이튠즈 미리듣기 url

            resultList.add(i,map);


         /* model.addAttribute("artistName",jsonResponse.getResults().get(i).getArtistName());                  //아티스트 이름
            model.addAttribute("collectionName",jsonResponse.getResults().get(i).getCollectionName());          //앨범이름
            model.addAttribute("trackName",jsonResponse.getResults().get(i).getTrackName());                    //음악이름
            model.addAttribute("artistViewUrl",jsonResponse.getResults().get(i).getArtistViewUrl());            //아이튠스내 아티스트소개
            model.addAttribute("collectionViewUrl",jsonResponse.getResults().get(i).getCollectionViewUrl());    //아이튠스내 앨범소개 url
            model.addAttribute("artworkUrl30",jsonResponse.getResults().get(i).getArtworkUrl30());              //앨범사진 30*30
            model.addAttribute("previewUrl",jsonResponse.getResults().get(i).getPreviewUrl());                  //아이튠즈 미리듣기 url*/

        }
        System.out.println(resultList.get(0));
        System.out.println(resultList.get(1));
        System.out.println(resultList);

        model.addAttribute("resultList" , resultList);

        return "search/search";
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
