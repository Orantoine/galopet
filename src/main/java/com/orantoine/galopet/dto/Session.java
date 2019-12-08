package com.orantoine.galopet.dto;


import lombok.Data;
import lombok.Generated;
import org.joda.time.LocalTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.util.List;

@Data
public class Session {

    private String id;

    private List<Player> playerList;

    private String time;

    private String dateId;

    private Integer hours;

    private Integer minuts;


}
