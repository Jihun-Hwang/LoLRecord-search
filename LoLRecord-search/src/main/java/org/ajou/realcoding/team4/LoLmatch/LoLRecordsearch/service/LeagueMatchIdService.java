package org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.service;

import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.api.LeagueApiClient;
import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.api.LeagueMatchIdApiClient;
import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.domain.LeagueEntry;
import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.domain.LeagueMatchId;
import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.repository.LeagueEntryRepository;
import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.repository.LeagueMatchIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


@Service
//@EnableScheduling
public class LeagueMatchIdService {
    @Autowired
    private LeagueMatchIdApiClient leagueMatchIdApiClient;
    @Autowired
    private LeagueMatchIdRepository leagueMatchIdRepository;

    // private Queue<String> savedEncryptedAccountIdQueue = new LinkedList<>();
    //String apiKey;

    public LeagueMatchId getFiveLeagueMatchId (String encryptedAccountId, String apiKey) {
        LeagueMatchId currentLeagueMatchId = leagueMatchIdApiClient.getMatchIdRecentFive(encryptedAccountId, apiKey);
        // leagueMatchIdRepository.saveFiveLeagueMatchID(currentLeagueMatchId);

        // leagueMatchIdRepository.saveFiveLeagueMatchID(leagueMatchId);
        // this.apiKey = apiKey;

        return currentLeagueMatchId;
    }
/*
    @Scheduled(fixedDelay = 1500L)
    public void getCurrentLoLFiveGameIDsEveryTwoSeconds(){
        String targetEncryptedAccountId = savedEncryptedAccountIdQueue.poll();
        if(targetEncryptedAccountId != null){
            savedEncryptedAccountIdQueue.add(targetEncryptedAccountId);
            LeagueMatchId leagueMatchId = leagueMatchIdApiClient.getMatchIdRecentFive(targetEncryptedAccountId,this.apiKey);
            leagueMatchIdRepository.saveFiveLeagueMatchID(leagueMatchId);
        }
    } */
}
