package com.orantoine.galopet.services;

import com.orantoine.galopet.dto.Day;
import com.orantoine.galopet.dto.Player;
import com.orantoine.galopet.repositories.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DayService {

    @Autowired
    private DayRepository dayRepository;


    public List<Day> getAll(){
        return dayRepository.findAll();
    }

    public List<Day> saveAll(List<Day> days){
        return dayRepository.saveAll(days);
    }

    public Day findById(String id){
        Optional<Day> dayOptional = dayRepository.findById(id);
        return dayOptional.orElse(null);
    }

    public void deleteDay(String id){
        dayRepository.deleteById(id);
    }

    public Day addPlayer(Day dayFound, Player playerFound) {
        if(dayFound.getPlayerEngaged() == null){
            dayFound.setPlayerEngaged(new ArrayList<>());
        }
        dayFound.getPlayerEngaged().add(playerFound);
        dayRepository.save(dayFound);
        return dayFound;
    }
}
