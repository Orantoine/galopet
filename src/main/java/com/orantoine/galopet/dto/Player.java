package com.orantoine.galopet.dto;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity(name = "player")
public class Player {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pseudo")
    private String pseudo;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "level")
    private int level;


}
