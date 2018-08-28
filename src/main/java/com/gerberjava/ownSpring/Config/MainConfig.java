package com.gerberjava.ownSpring.Config;

import com.gerberjava.ownSpring.domain.repository.BankAccountMemRepo;
import com.gerberjava.ownSpring.domain.repository.BankAccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MainConfig
{
    @Bean(name="BankAccountMemRepo")
    @Profile("dev")
    public BankAccountRepository createInMemoryRep()
    {
        BankAccountRepository repo = new BankAccountMemRepo();
        return repo;
    }
}
