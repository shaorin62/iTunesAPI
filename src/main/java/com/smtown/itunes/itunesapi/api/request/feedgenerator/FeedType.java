package com.smtown.itunes.itunesapi.api.request.feedgenerator;

import com.smtown.itunes.itunesapi.api.FeedGenerator;

public enum FeedType {

    TOP_AUDIOBOOKS("top-audiobooks"),
    TOP_PAID("top-paid"),
    TOP_FREE("top-free"),
    NEW_APPS_WE_LOVE("new-apps-we-love"),
    NEW_GAMES_WE_LOVE("new-games-we-love"),
    TOP_FREE_IPAD("top-free-ipad"),
    TOP_GROSSING_IPAD("top-grossing-ipad"),
    TOP_GROSSING("top-grossing"),
    TOP_FREE_GAMES("top-free-games"),
    TOP_PAID_GAMES("top-paid-games"),
    TOP_ITUNES_U_COLLECTION("top-itunes-u-collection"),
    TOP_ITUNES_U_COURSES("top-itunes-u-courses"),
    TOP_MOVIES("top-movies"),
    TOP_MOVIES_ACTION_AND_ADVENTURE("top-movies-action-and-adventure"),
    TOP_MOVIES_DOCUMENTARY("top-movies-documentary"),
    TOP_MUSIC_VIDEOS("top-music-videos"),
    TOP_PODCASTS("top-podcasts"),
    TOP_TV_EPISODES("top-tv-episodes"),
    TOP_TV_SEASONS("top-tv-seasons"),
    NEW_MUSIC("new-music"),
    RECENT_RELEASES("recent-releases"),
    HOT_ALBUMS("hot-albums"),
    TOP_SONGS("top-songs"),
    TOP_ALBUMS("top-albums"),
    TOP_SONGS_COUNTRY("top-songs-country"),
    HOT_TRACKS("hot-tracks"),
    HOT_TRACKS_COUNTRY("hot-tracks-country"),
    TOP_MAC_APPS("top-mac-apps"),
    TOP_FREE_MAC_APPS("top-free-mac-apps"),
    TOP_PAID_MAC_APPS("top-paid-mac-apps"),
    TOP_GROSSING_MAC_APPS("top-grossing-mac-apps");

    private final String code;
    private FeedType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
