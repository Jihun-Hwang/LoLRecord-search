package org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.repository;

import lombok.extern.slf4j.Slf4j;
import org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.domain.LeagueEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class LeagueEntryRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    private void saveLeagueEntry(LeagueEntry leagueEntry) {
        LeagueEntry savedLeagueEntry = mongoTemplate.save(leagueEntry[0]);
        log.info("Saved: {}", savedLeagueEntry);
    }
}
