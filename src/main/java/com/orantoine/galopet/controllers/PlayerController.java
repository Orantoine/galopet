package com.orantoine.galopet.controllers;


import com.orantoine.galopet.dto.Player;
import com.orantoine.galopet.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;


    @GetMapping(path = "/player")
    public ResponseEntity<List<Player>> findAll(){
        List<Player> playerList = playerService.findAll();
        return ResponseEntity.ok(playerList);
    }

    @PostMapping(path = "/player")
    public ResponseEntity<Player> addPlayer(@RequestBody Player player){
        Player newPlayer = playerService.addPlayer(player);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPlayer);
    }
}
