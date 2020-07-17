package org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.api;

import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.domain.LeagueEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LeagueApiClient {
    @Autowired
    public RestTemplate restTemplate;
    public static final String LEAGUE_REQUEST_URI = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/{encryptedSummonerId}?api_key={apiKey}";

    public LeagueEntry getLeagueEntry(String encryptedSummonerId, String apiKey) {
        LeagueEntry leagueEntry = restTemplate.getForObject(LEAGUE_REQUEST_URI, LeagueEntry.class, encryptedSummonerId, apiKey);
        return leagueEntry;
    }
}
