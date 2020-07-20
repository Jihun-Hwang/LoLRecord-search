package org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.domain;

import lombok.Data;

import java.util.List;

@Data
public class MatchInfo {
    private long gameId;
    private List<Teams> teams;
    private List<Participants> participants;
    private List<ParticipantIdentities> participantIdentities;

    @Data
    public static class Teams{
        private int teamId;
        private String win;
    }

    @Data
    public static class Participants{
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

    @Data
    public static class ParticipantIdentities{
        private int participantId;
        private Player player;

        @Data
        public static class Player{
            private String summonerName;
        }
    }

}
