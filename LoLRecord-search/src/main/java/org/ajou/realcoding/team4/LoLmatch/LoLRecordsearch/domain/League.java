package org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.domain;

import lombok.Data;

@Data
public class League {

    /*
    {
        "leagueId": "2d916f43-ef5a-4625-8533-f943f7f99c81",
        "queueType": "RANKED_SOLO_5x5",
        "tier": "SILVER",
        "rank": "III",
        "summonerId": "cTJRw-gsfTz7Rd5Yy-MFegnTIyeM2rCIPeWYPgB4hPrrIsk",
        "summonerName": "BLACKGREYWHITE",
        "leaguePoints": 8,
        "wins": 33,
        "losses": 38,
        "veteran": false,
        "inactive": false,
        "freshBlood": false,
        "hotStreak": false
    }
    */

    private String leagueId;
    private String queueType;
    private String tier;
    private String rank;
    private String summonerId;
    private String summonerName;
    private int leaguePoints;
    private int wins;
    private int losses;
    private boolean veteran;
    private boolean inactive;
    private boolean freshBlood;
    private boolean hotStreak;
}
