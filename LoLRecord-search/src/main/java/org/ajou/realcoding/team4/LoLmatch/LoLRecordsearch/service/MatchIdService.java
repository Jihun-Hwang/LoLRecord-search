package org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.service;

import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.api.MatchIdApiClient;
import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.domain.MatchId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchIdService {
    @Autowired
    private MatchIdApiClient matchIdApiClient;

    public MatchId getFiveMatchId(String encryptedAccountId, String apiKey) {
        MatchId currentLeagueMatchId = matchIdApiClient.getMatchIdRecentFive(encryptedAccountId, apiKey);
        return currentLeagueMatchId;
    }

}
