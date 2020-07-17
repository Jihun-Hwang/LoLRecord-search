package org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class LeagueMatchId {
    @Id
    private long gameId;
    private int champion;
}

