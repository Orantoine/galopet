package com.orantoine.galopet.services;


import com.orantoine.galopet.dto.Day;
import com.orantoine.galopet.dto.Session;
import com.orantoine.galopet.repositories.DayRepository;
import com.orantoine.galopet.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SessionService {

    @Autowired
    private DayRepository dayRepository;

    @Autowired
    private SessionRepository sessionRepository;

    public Day AddSessionsToDay(List<Session> sessions, Day day){
        for (Session session: sessions) {
            if(session.getTime().contains("H") && session.getTime().contains("m")){
                String[] timeSplit = session.getTime().split("H");
                session.setMinuts(Integer.parseInt(timeSplit[1].split("m")[0]));
                session.setHours(Integer.parseInt(timeSplit[0]));
                session.setDateId(day.getId());
                sessionRepository.save(session);
            }
            else{
                sessions.remove(session);
            }
        }
        if(day.getSessionList() == null){
            day.setSessionList(new ArrayList());
        }
        day.getSessionList().addAll(sessions);
        dayRepository.save(day);
        return day;
    }

    public Day deleteSession(String session, Day dayFound) {
        sessionRepository.deleteById(session);
        dayFound.getSessionList().removeIf( x-> x.getId().equals(session));
        dayRepository.save(dayFound);
        return dayFound;
    }
}
