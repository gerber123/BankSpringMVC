package com.gerberjava.ownSpring.domain.repository;

import com.gerberjava.ownSpring.Utils.Ids;
import com.gerberjava.ownSpring.domain.Locate;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Scope("singleton")
public class LocateRepository
{
    List<Locate> locateList = new ArrayList<>();
    Map<Integer,Locate> locates = new HashMap<>();
    Random rand = new Random();

    public void createLocate(String description)
    {
        int newId = Ids.generateNewId(locates.keySet());
        Locate locate = new Locate(newId,description);
        locates.put(newId,locate);
    }
    public List<Locate> getAll()
    {
        return new ArrayList<>(locates.values());
    }
    public void deleteLocate(Locate locate)
    {
        locates.remove(locate.getId());
    }
    @Scheduled(fixedDelay = 3000)
    public void createRandomQuest()
    {
        List<String> descriptions = new ArrayList<>();
        descriptions.add("Lokata miesieczna 2%");
        descriptions.add("Lokata 3 minutowa 1%");
        descriptions.add("Lokata 1 minuta 2%");
        descriptions.add("Lokata 100% w rok");
        String description = descriptions.get(rand.nextInt(descriptions.size()));
//        System.out.println("Utworzyłem zadanie o opisie: "+description);
        createLocate(description);
    }
    public void update(Locate locate) {
        locates.put(locate.getId(),locate);
    }
    public Locate getLocate(Integer id)
    {
        return locates.get(id);
    }
}
