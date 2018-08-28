package com.gerberjava.ownSpring.Services;

import com.gerberjava.ownSpring.domain.BankAccount;
import com.gerberjava.ownSpring.domain.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountService
{
    @Autowired
    BankAccountRepository bankAccountRepository;

    public BankAccount getBankAccount(Integer id)
    {
        return bankAccountRepository.getBankAccountById(id);
    }
    public List<BankAccount> getAllAccounts()
    {
        return new ArrayList<>(bankAccountRepository.getAllAcounts());
    }

    public void registerAccount(BankAccount bankAccount)
    {
        bankAccountRepository.createBankAcc(bankAccount);
    }
    public void updateAccount(BankAccount bankAccount)
    {
        bankAccountRepository.updateBankAccount(bankAccount.getId(),bankAccount);
    }
}
