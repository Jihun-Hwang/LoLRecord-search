package org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.api;

import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.domain.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SummonerApiClient {
    @Autowired
    public RestTemplate restTemplate;
    public static final String SUMMONER_REQUEST_URI="https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{name}?api_key={apiKey}";

    public Summoner getSummonerId(String name, String apiKey) {
        Summoner summoner = restTemplate.getForObject(SUMMONER_REQUEST_URI, Summoner.class, name, apiKey);
        return summoner;
    }
}
