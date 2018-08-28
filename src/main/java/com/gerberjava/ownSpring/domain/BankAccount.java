package com.gerberjava.ownSpring.domain;


import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BankAccount
{
    @NotNull
    @Size(min=2,max=40, message = "Podałeś za mało liter")
    private String name;

    @NotNull
    @Size(min=2,max=40, message = "Podałeś za mało liter")
    private String surname;

    @NotNull
    @Range(min=16,max=60, message = "Użytkownicy naszego banku muszą mieć ukończone 16 lat")
    private int age;

    @NotNull
    @Size(min=4,max=40,message = "Uważaj, proste hasła łatwo odgadnąć")
    private String password;

    private String checkPassword;
    private int CashAmount;
    private int id;
    private Locate locate;

    public BankAccount() {
    }

    public BankAccount(String name, String surname)
    {
        this.name=name;
        this.surname=surname;
    }

    public Locate getLocate() {
        return locate;
    }

    public void setLocate(Locate locate) {
        this.locate = locate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCashAmount() {
        return CashAmount;
    }

    public void setCashAmount(int cashAmount) {
        CashAmount = cashAmount;
    }

    public String getCheckPassword() {
        return checkPassword;
    }

    public void setCheckPassword(String checkPassword) {
        this.checkPassword = checkPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
