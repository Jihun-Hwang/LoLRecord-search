package org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.domain;

import lombok.Data;

import java.util.List;

@Data
public class MatchInfo {  // Match information
    private long gameId;
    private List<Teams> teams;
    private List<Participants> participants;

    @Data
    public static class Teams{
        private int teamId;
        private String win;
        //private boolean win;
    }

    @Data
    public static class Participants{ // Information about the requested summoner
        private int participantId;
        private int teamId;
        private int championId;
        private Stats stats;

        @Data
        public static class Stats{
            private int participantId;
            private boolean win;
            private int kills;
            private int deaths;
            private int assists;
        }

    }

}
