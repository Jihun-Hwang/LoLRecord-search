package org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.service;

import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.api.LeagueApiClient;
import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.api.LeagueMatchIdApiClient;
import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.domain.LeagueEntry;
import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.domain.LeagueMatchId;
import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.repository.LeagueEntryRepository;
import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.repository.LeagueMatchIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LeagueMatchIdService {
    @Autowired
    private LeagueMatchIdApiClient leagueMatchIdApiClient;

    @Autowired
    private LeagueMatchIdRepository leagueMatchIdRepository;

    public LeagueMatchId[] getFiveLeagueMatchId(String encryptedAccountId, String apiKey){
        LeagueMatchId[] leagueMatchIds = leagueMatchIdApiClient.getMatchIdRecentFive(encryptedAccountId,apiKey);
        leagueMatchIdRepository.saveFiveLeagueMatchID(leagueMatchIds);
        return leagueMatchIds;
    }
}
