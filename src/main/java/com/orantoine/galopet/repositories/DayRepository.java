package com.orantoine.galopet.repositories;

import com.orantoine.galopet.dto.Day;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DayRepository extends MongoRepository<Day,String> {
}
