package org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.controller;

import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.domain.LeagueEntry;
import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.domain.LeagueMatchId;
import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.domain.MatchInfo;
import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.domain.Summoner;
import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.repository.LeagueMatchIdRepository;
import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.service.LeagueApiService;
import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.service.LeagueMatchIdService;
import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.service.MatchInfoService;
import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.service.SummonerApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    @Autowired
    private SummonerApiService summonerApiService;
    @Autowired
    private LeagueApiService leagueApiService;
    @Autowired
    private LeagueMatchIdService leagueMatchIdService;
    @Autowired
    private MatchInfoService matchInfoService;


//    @Autowired
//    private LeagueMatchIdService leagueMatchIdService;

    @GetMapping("/summonerApi-service/summoners")
    public List<MatchInfo> getSummoner(@RequestParam String SummonerId, @RequestParam String apiKey) {
        Summoner currentSummoner = summonerApiService.getSummoner(SummonerId, apiKey);  // step2
        //LeagueEntry currentLeagueEntry = leagueApiService.getLeagueEntry(currentSummoner.getId(), apiKey); // step3
        LeagueMatchId currentFiveLeagueMatchId = leagueMatchIdService.getFiveLeagueMatchId(currentSummoner.getAccountId(), apiKey); // step4
        List<MatchInfo> matchInfoList = matchInfoService.getMatchInfoList(currentFiveLeagueMatchId, apiKey); // step5

        return matchInfoList;
    }

/*
    @GetMapping("/leagueApi-service/leagues")
    public LeagueEntry getLeagueEntry(@RequestParam String encryptedSummonerId, @RequestParam String apiKey) {
        return leagueApiService.getLeagueEntry(encryptedSummonerId, apiKey);
    }
/*
    @GetMapping("/leagueMatch-service/matchIDs")
    public LeagueMatchId getLFiveMatchId(@RequestParam String encryptedAccountId, @RequestParam String apiKey) {
        return leagueMatchIdService.getFiveLeagueMatchId(encryptedAccountId, apiKey);
    }

 */
}