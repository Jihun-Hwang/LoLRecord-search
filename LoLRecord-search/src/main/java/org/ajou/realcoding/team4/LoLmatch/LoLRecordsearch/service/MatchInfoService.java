package org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.service;

import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.api.MatchInfoApiClient;
import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.domain.MatchId;
import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.domain.MatchInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class MatchInfoService {
    @Autowired
    private MatchInfoApiClient matchInfoApiClient;

    public List<MatchInfo> getMatchInfoList(MatchId currentFiveLeagueMatchId, String apiKey) {
        List<MatchInfo> matchInfoList = new LinkedList<>();
        for(int i = 0; i < 5; i++){
            matchInfoList.add(
                    matchInfoApiClient.getMatchInfoApi(currentFiveLeagueMatchId.getMatches().get(i).getGameId(), apiKey)
            );
        }

        return matchInfoList;
    }
}
