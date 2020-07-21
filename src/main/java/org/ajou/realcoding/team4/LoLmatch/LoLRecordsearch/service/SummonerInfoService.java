package org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.service;

import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.api.SummonerApiClient;
import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.domain.Summoner;
import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.repository.SummonerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SummonerInfoService {
    @Autowired
    private SummonerApiClient summonerApiClient;
    @Autowired
    private SummonerRepository summonerRepository;

    public Summoner getSummoner(String name, String apiKey) {
        Summoner currentSummoner = summonerRepository.findSummonerId(name);
        if(currentSummoner == null) {
            currentSummoner = summonerApiClient.getSummonerId(name, apiKey);
            summonerRepository.saveSummonerId(currentSummoner);
        }
        return currentSummoner;
    }
}
