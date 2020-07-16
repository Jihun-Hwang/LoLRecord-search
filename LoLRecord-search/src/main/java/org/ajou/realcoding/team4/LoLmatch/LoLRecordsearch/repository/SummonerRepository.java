package org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.repository;

import lombok.extern.slf4j.Slf4j;
import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.domain.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class SummonerRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void saveSummonerId(Summoner summoner) {
        Summoner savedId=mongoTemplate.save(summoner);
        log.info("Saved: {}", savedId);
    }

    public Summoner findSummonerId(String name) {
        Query query = Query.query(
                Criteria.where("_id").is(name)
        );
        Summoner summoner = (Summoner) mongoTemplate.findOne(query, Summoner.class);
        log.info("Found summoner id! id: {} ", name);
        return summoner;
    }
}