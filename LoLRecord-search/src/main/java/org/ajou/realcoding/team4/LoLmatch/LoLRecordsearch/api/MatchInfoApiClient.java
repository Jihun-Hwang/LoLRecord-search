package org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.api;

import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.domain.MatchInfo;
import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.domain.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class MatchInfoApiClient {
    @Autowired
    public RestTemplate restTemplate;
    public static final String MATCHINFO_REQUEST_URI = "https://kr.api.riotgames.com/lol/match/v4/matches/{matchId}?api_key={apiKey}";

    public MatchInfo getMatchInfoApi(long gameId, String apiKey) {
        MatchInfo currentMatchInfo = restTemplate.getForObject(MATCHINFO_REQUEST_URI, MatchInfo.class, gameId, apiKey);
        return currentMatchInfo;
    }
}
