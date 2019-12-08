package com.orantoine.galopet.controllers;


import com.orantoine.galopet.dto.Day;
import com.orantoine.galopet.dto.Player;
import com.orantoine.galopet.dto.Session;
import com.orantoine.galopet.services.DayService;
import com.orantoine.galopet.services.PlayerService;
import com.orantoine.galopet.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    private DayService dayService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private SessionService sessionService;

    @GetMapping( path = "/reservations")
    public ResponseEntity<List<Day>> getDays(){
        return ResponseEntity.ok(dayService.getAll());
    }

    @PostMapping(path = "/reservations")
    public ResponseEntity<List<Day>> newDays(@RequestBody List<Day> days){
        return ResponseEntity.status(HttpStatus.CREATED).body(dayService.saveAll(days));
    }

    @PutMapping(path = "/reservations/{id}")
    public ResponseEntity<Day> addPlayerToSession(@PathVariable String id, @RequestParam String player){
        Player playerFound = playerService.findById(player);
        Day dayFound = dayService.findById(id);
        if(dayFound != null && playerFound != null){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(dayService.addPlayer(dayFound,playerFound));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping(path = "/reservations/{id}")
    public ResponseEntity<Void> deleteDay(@PathVariable String id){
        dayService.deleteDay(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    
    @DeleteMapping(path = "/reservations/{id}/{playerId}")
    public ResponseEntity<Day> deleteEngage(@PathVariable String id, @PathVariable String playerId){
        Day dayFound = dayService.findById(id);
        if(dayFound != null && dayFound.getPlayerEngaged() != null){
            dayFound.getPlayerEngaged().removeIf(x-> x.getPseudo().equals(playerId));
            return ResponseEntity.ok(dayFound);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping(path = "/reservations/{id}/sessions")
    public ResponseEntity<Day> AddSessions(@PathVariable String id, @RequestBody List<Session> sessions){
        Day dayFound = dayService.findById(id);
        if(dayFound != null){
            return ResponseEntity.ok(sessionService.AddSessionsToDay(sessions,dayFound));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping(path =  "/reservations/{id}/sessions")
    public ResponseEntity<List<Session>> getSessionsForDay(@PathVariable String id){
        Day dayFound = dayService.findById(id);
        if(dayFound!=null){
            return ResponseEntity.ok(dayFound.getSessionList());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping(path = "/reservations/{id}/sessions")
    public ResponseEntity<Day> deleteSessionForDay(@PathVariable String id, @RequestParam String session){
        Day dayFound = dayService.findById(id);
        if(dayFound!= null){
            return ResponseEntity.ok(sessionService.deleteSession(session,dayFound));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


}
