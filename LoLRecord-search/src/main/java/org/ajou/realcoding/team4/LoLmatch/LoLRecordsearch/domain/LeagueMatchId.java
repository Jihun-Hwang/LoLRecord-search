package org.ajou.realcoding.team4.LoLmatch.LoLRecordsearch.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Data
public class LeagueMatchId {
   // @Id
   // private int startIndex;
   // private int endIndex;
   // private int totalGames;
    private List<Matches> matches;

    @Data
    public static class Matches{
     //   private String platformId;
        private long gameId;
      //  private int champion;
      //  private int queue;
      //  private int season;
      //  private long timestamp;
      //  private String role;
       // private String lane;

    }


}

