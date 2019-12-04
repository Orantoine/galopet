package com.orantoine.galopet.services;

import com.orantoine.galopet.dto.Player;
import com.orantoine.galopet.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PlayerService {


    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> findAll(){
        return playerRepository.findAll();
    }

    public Player addPlayer(Player player){
        return playerRepository.save(player);
    }
}
