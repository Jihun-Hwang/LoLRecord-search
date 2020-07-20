package org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.api;


import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.domain.MatchId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MatchIdApiClient {

    @Autowired
    public RestTemplate restTemplate;
    public static final String MATCHID_REQUEST_URI = "https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/{encryptedAccountId}?endIndex=5&api_key={apiKey}";


    public MatchId getMatchIdRecentFive(String encryptedAccountId, String apiKey) {
        MatchId leagueMatchId = restTemplate.getForObject(MATCHID_REQUEST_URI, MatchId.class, encryptedAccountId, apiKey);
        return leagueMatchId;
    }

}
