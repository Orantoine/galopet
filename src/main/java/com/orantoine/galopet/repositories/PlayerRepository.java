package com.orantoine.galopet.repositories;

import com.orantoine.galopet.dto.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<Player,String> {
}
