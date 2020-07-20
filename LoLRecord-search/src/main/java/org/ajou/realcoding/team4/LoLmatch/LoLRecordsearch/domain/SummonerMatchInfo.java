package org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.domain;

import lombok.Data;


@Data
public class SummonerMatchInfo {
    private long gameId;
    private String name;
    private int participantId;
    private int teamId;
    private boolean win;
    private int championId;
    private int kills;
    private int deaths;
    private int assists;

}
