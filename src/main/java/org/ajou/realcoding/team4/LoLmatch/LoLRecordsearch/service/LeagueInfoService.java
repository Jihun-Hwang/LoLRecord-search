package org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.service;

import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.api.LeagueApiClient;
import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.domain.LeagueEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeagueInfoService {
    @Autowired
    private LeagueApiClient leagueApiClient;

    public LeagueEntry getLeagueEntry(String encryptedSummonerId, String apiKey) {
        LeagueEntry[] leagueEntry = leagueApiClient.getLeagueEntry(encryptedSummonerId, apiKey);
        return leagueEntry[0];
    }
}
