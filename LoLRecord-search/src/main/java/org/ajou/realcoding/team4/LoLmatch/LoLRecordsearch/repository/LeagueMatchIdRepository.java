package org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.repository;

import lombok.extern.slf4j.Slf4j;
import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.domain.LeagueMatchId;
import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.domain.LeagueMatchId.Matches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class LeagueMatchIdRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void saveFiveLeagueMatchID(LeagueMatchId leagueMatchId){
        LeagueMatchId savedGameIDs = mongoTemplate.save(leagueMatchId);
        log.info("Found id! id: {} ", savedGameIDs);
    }
}

