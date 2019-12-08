package com.orantoine.galopet.repositories;

import com.orantoine.galopet.dto.Session;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SessionRepository extends MongoRepository<Session,String> {
}
