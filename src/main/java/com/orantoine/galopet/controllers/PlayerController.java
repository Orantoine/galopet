package com.orantoine.galopet.controllers;


import com.orantoine.galopet.dto.Player;
import com.orantoine.galopet.services.PlayerService;
import io.micrometer.core.annotation.Timed;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@RestController
public class PlayerController {

    private static final Logger logger = LogManager.getLogger(PlayerController.class);

    @Autowired
    private PlayerService playerService;


    @GetMapping(path = "/player")
    public ResponseEntity<List<Player>> findAll(){
        List<Player> playerList = playerService.findAll();
        return ResponseEntity.ok(playerList);
    }

    @Timed(value = "Player_Creation_Time")
    @PostMapping(path = "/player")
    public ResponseEntity<Player> addPlayer(@RequestBody Player player){
        Player newPlayer = playerService.addPlayer(player);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPlayer);
    }

    @DeleteMapping(path = "/player/{id}")
    public ResponseEntity<Void> DeletePlayer(@PathVariable String id){
        try {
            playerService.deletePlayer(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            logger.error("Error while deleting Player",e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
