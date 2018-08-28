package com.gerberjava.ownSpring.domain.repository;

import com.gerberjava.ownSpring.domain.BankAccount;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collection;
import java.util.Optional;

public interface BankAccountRepository {
    default void updateBankAccount(int id, BankAccount bankAccount)
    {
        throw new NotImplementedException();
    };

    void createBankAcc(String name, String surname);

    void build();
    public BankAccount getBankAccountById(Integer id);
    Optional<BankAccount> getBankAccount(String name);

    Collection<BankAccount> getAllAcounts();

    void createBankAcc(BankAccount bankAccount);
}
