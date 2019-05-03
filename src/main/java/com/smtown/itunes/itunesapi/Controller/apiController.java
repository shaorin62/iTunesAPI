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
import com.smtown.itunes.itunesapi.api.response.genreidsappendix.GenreIdsResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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

        Response jsonResponse = new Search("NCT")
                .setCountry(Country.SOUTH_KOREA)
                .setMedia(Media.MUSIC)
                .setEntity(Entity.MUSIC_TRACK)
                .setLimit(10)
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
            map.put("artworkUrl60",jsonResponse.getResults().get(i).getArtworkUrl60());             //앨범사진 30*30
            map.put("previewUrl",jsonResponse.getResults().get(i).getPreviewUrl());                 //아이튠즈 미리듣기 url

            resultList.add(i,map);
        }

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
        String returnValue = lookupResponse.toString();

        return returnValue;
    }

    @RequestMapping("/feedGenerator")
    public String feedGenerator(Model model){

        List<Map<String, String>> resultList = new ArrayList<>(); //결과 정보 List

        String responseUrl = new FeedGenerator()
                .setCountry(Country.SOUTH_KOREA)
                .setMediaType(MediaType.APPLE_MUSIC)
                .setFeedType(FeedType.TOP_SONGS)
                .setResultsLimit(10)
                .getUrl();

        Feed responseFeed = new FeedGenerator()
                .setAllowExplicit(true)
                .setCountry(Country.SOUTH_KOREA)
                .setMediaType(MediaType.APPLE_MUSIC)
                .setFeedType(FeedType.TOP_SONGS)
                .setResultsLimit(10)
                .execute();

        for(int i =0; i < responseFeed.getResults().size(); i++ ){

            Map<String,String> map = new HashMap<>();

            map.put("ranking", "" + (i + 1));         //순위
            map.put("artistName",responseFeed.getResults().get(i).getArtistName());         //아티스트명
            map.put("releaseDate",responseFeed.getResults().get(i).getReleaseDate());       //발매일자
            map.put("artworkUrl100",responseFeed.getResults().get(i).getArtworkUrl100());   //앨범자캣 이미지
            map.put("copyRight",responseFeed.getResults().get(i).getCopyright());           //저작권
            map.put("id",responseFeed.getResults().get(i).getId());                         //id
            map.put("kind",responseFeed.getResults().get(i).getKind());                     //종류
            map.put("name",responseFeed.getResults().get(i).getName());                     //음원명칭
            map.put("url",responseFeed.getResults().get(i).getUrl());                       //앨범정보

            resultList.add(i,map);
        }

        model.addAttribute("resultList", resultList);
        System.out.println("System확인 결과" + resultList);
        return "list/list";
    }
}
