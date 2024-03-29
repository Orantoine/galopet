package com.orantoine.galopet.dto;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "player")
public class Player {


    @Id
    private String id;


    private String pseudo;

    private String firstname;

    private String lastname;

    private Integer level;


}
