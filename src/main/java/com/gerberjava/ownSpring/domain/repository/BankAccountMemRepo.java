package com.gerberjava.ownSpring.domain.repository;

import com.gerberjava.ownSpring.Utils.Ids;
import com.gerberjava.ownSpring.domain.BankAccount;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class BankAccountMemRepo implements BankAccountRepository {
    Map<Integer, BankAccount> bankAccounts = new HashMap<>();

    public BankAccountMemRepo()
    {

    }

    @Override
    public void updateBankAccount(int id, BankAccount bankAccount)
    {
        bankAccounts.put(id,bankAccount);
    }
    @Override
    public BankAccount getBankAccountById(Integer id) {
        return bankAccounts.get(id);
    }

    @Override
    public void createBankAcc(String name, String surname)
    {
        BankAccount bankAcc = new BankAccount(name,surname);
        bankAcc.setId(Ids.generateNewId(bankAccounts.keySet()));
        bankAcc.setCashAmount(100);
        bankAccounts.put(bankAcc.getId(),bankAcc);
    }

    @PostConstruct
    public void build()
    {
        createBankAcc("Garbarczyk","Marcin");
        createBankAcc("Garbarczyk","Marcin");
    }

    @Override
    public Optional<BankAccount> getBankAccount(String name)
    {
        Optional<BankAccount> accountByName = bankAccounts.values().stream().filter(bankAccount -> bankAccount.getName().equals(name)).findAny();

        return accountByName;
    }

    @Override
    public Collection<BankAccount> getAllAcounts() {
        return bankAccounts.values();
    }

    @Override
    public void createBankAcc(BankAccount bankAccount)
    {
        bankAccount.setId(Ids.generateNewId(bankAccounts.keySet()));
        bankAccounts.put(bankAccount.getId(),bankAccount);
    }
}
