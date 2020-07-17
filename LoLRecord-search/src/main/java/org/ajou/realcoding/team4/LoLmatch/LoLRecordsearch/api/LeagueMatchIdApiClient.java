package org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.api;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.domain.LeagueMatchId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeagueMatchIdApiClient {

    @Autowired
    public RestTemplate restTemplate;
    public static final String MATCHID_REQUEST_URI = "https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/{encryptedAccountId}?endIndex=5&api_key={apiKey}";


    public LeagueMatchId getMatchIdRecentFive(String encryptedAccountId, String apiKey) {
        LeagueMatchId leagueMatchId = restTemplate.getForObject(MATCHID_REQUEST_URI, LeagueMatchId.class, encryptedAccountId, apiKey);
        return leagueMatchId;
    }

}
