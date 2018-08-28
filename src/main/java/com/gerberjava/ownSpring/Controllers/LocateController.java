package com.gerberjava.ownSpring.Controllers;

import com.gerberjava.ownSpring.Services.AccountService;
import com.gerberjava.ownSpring.Services.LocateService;
import com.gerberjava.ownSpring.domain.BankAccount;
import com.gerberjava.ownSpring.domain.Locate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
public class LocateController
{
    @Autowired
    AccountService accountService;

    @Autowired
    LocateService locateService;


    @RequestMapping("/assignLocate")
    public String assignLocate(@RequestParam("accountId") Integer id, Model model)
    {

        BankAccount bankAccount = accountService.getBankAccount(id);
        List<Locate> allLocates=locateService.getAllLocates();
        model.addAttribute("bankAccount",bankAccount);
        model.addAttribute("allLocates",allLocates);

        return "assignLocate";
    }

    @RequestMapping(value = "/assignLocate", method = RequestMethod.POST)
    public String assignLocate(BankAccount bankAccount)
    {

        accountService.updateAccount(bankAccount);
        Locate locate = bankAccount.getLocate();
       locateService.update(locate);
        return "redirect:/bankAccounts";
    }
}
