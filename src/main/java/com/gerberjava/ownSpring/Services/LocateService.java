package com.gerberjava.ownSpring.Services;

import com.gerberjava.ownSpring.domain.Locate;
import com.gerberjava.ownSpring.domain.repository.BankAccountRepository;
import com.gerberjava.ownSpring.domain.repository.LocateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class LocateService
{
    LocateRepository locateRepository;

    @Autowired
    BankAccountRepository bankAccountRepository;

    final static Random rand = new Random();

    public List<Locate> getAllLocates()
    {
        return locateRepository.getAll();
    }

    @Autowired
    public void setLocateRepository(LocateRepository locateRepository)
    {
        this.locateRepository=locateRepository;
    }
    public void update(Locate locate)
    {
        locateRepository.update(locate);
    }
}
