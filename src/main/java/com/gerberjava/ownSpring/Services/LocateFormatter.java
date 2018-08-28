package com.gerberjava.ownSpring.Services;

import com.gerberjava.ownSpring.domain.Locate;
import com.gerberjava.ownSpring.domain.repository.LocateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Locale;

@Service
public class LocateFormatter implements Formatter<Locate>
{
    @Autowired
    LocateRepository locateRepository;

    @Override
    public Locate parse(String idAsStr, Locale locale) throws ParseException {
        Integer id = Integer.parseInt(idAsStr);
        return locateRepository.getLocate(id);

    }

    @Override
    public String print(Locate locate, Locale locale) {
        return locate.toString();
    }
}

