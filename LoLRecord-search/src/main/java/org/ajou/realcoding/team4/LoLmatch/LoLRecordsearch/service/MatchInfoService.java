package org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.service;

import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.domain.LeagueMatchId;
import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.domain.MatchInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service
public class MatchInfoService {
    @Autowired
    private MatchInfoApiClient matchInfoApiClient;

    public List<MatchInfo> getMatchInfoList(LeagueMatchId currentFiveLeagueMatchId, String apiKey) {
        List<MatchInfo> matchInfoList = new LinkedList<>();
        for(int i = 0; i < 5; i++){
            matchInfoList.add(
                    matchInfoApiClient.getMatchInfoApi(currentFiveLeagueMatchId.getMatches().get(i).getGameId())
            );
        }

        return matchInfoList;
    }
}
