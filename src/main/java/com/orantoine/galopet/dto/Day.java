package com.orantoine.galopet.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "day")
public class Day {

    @Id
    private String id;

    @Indexed(unique = true)
    private Date day;

    private List<Player> playerEngaged;

    private List<Session> sessionList;
}
