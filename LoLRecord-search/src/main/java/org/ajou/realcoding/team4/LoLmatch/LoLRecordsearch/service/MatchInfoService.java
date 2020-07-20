package org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.service;

import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.api.MatchInfoApiClient;
import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.domain.MatchId;
import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.domain.MatchInfo;
import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.domain.SummonerMatchInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class MatchInfoService {
    @Autowired
    private MatchInfoApiClient matchInfoApiClient;

    public List<SummonerMatchInfo> getMatchInfoList(String name,MatchId currentFiveLeagueMatchId, String apiKey) {
        //List<MatchInfo> matchInfoList = new LinkedList<>();
        List<SummonerMatchInfo> summonerMatchInfoList = new LinkedList<>();
        for(int i = 0; i < 5; i++){
            MatchInfo tempMatchInfo = matchInfoApiClient.getMatchInfoApi(currentFiveLeagueMatchId.getMatches().get(i).getGameId(), apiKey);
            SummonerMatchInfo tempSummonerMatchInfo = new SummonerMatchInfo();
            tempSummonerMatchInfo.setGameId(tempMatchInfo.getGameId());

            for(int j=0;j<10;j++){
                String tempName = tempMatchInfo.getParticipantIdentities().get(j).getPlayer().getSummonerName();
                if(tempName.equals(name)){
                    tempSummonerMatchInfo.setName(name);
                    tempSummonerMatchInfo.setParticipantId(tempMatchInfo.getParticipants().get(j).getParticipantId());
                    tempSummonerMatchInfo.setTeamId(tempMatchInfo.getParticipants().get(j).getTeamId());
                    tempSummonerMatchInfo.setWin(tempMatchInfo.getParticipants().get(j).getStats().isWin());
                    tempSummonerMatchInfo.setChampionId(tempMatchInfo.getParticipants().get(j).getChampionId());
                    tempSummonerMatchInfo.setKills(tempMatchInfo.getParticipants().get(j).getStats().getKills());
                    tempSummonerMatchInfo.setDeaths(tempMatchInfo.getParticipants().get(j).getStats().getDeaths());
                    tempSummonerMatchInfo.setAssists(tempMatchInfo.getParticipants().get(j).getStats().getAssists());
                    break;
                }
            }
            summonerMatchInfoList.add(tempSummonerMatchInfo);
        }

        return summonerMatchInfoList;
    }
}
