package com.gerberjava.ownSpring.Controllers;

import com.gerberjava.ownSpring.Services.AccountService;
import com.gerberjava.ownSpring.domain.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BankAccountController
{

    @Autowired
    AccountService accountService;

    @RequestMapping("/bankAccount")
    public String getBankAccount(@RequestParam("id")Integer id, Model model)
    {
        BankAccount b = accountService.getBankAccount(id);
        model.addAttribute("bankAccount",b);
        return "bankAccount";
    }

    @RequestMapping(value="/bankChecks",method= RequestMethod.POST)
    public String bankAccountCheck(BankAccount bankAccount) {

      accountService.getBankAccount(bankAccount.getId()).setCheckPassword(bankAccount.getCheckPassword());
      return "bankCheck";
//        List<BankAccount> allAccounts = new ArrayList<>(accountService.getAllAccounts());
//        model.addAttribute("bankAccount",allAccounts);

    }
    @RequestMapping("/bankCheck")
    public String getBankAccountCheck(@RequestParam("id")Integer id, Model model)
    {
        BankAccount b = accountService.getBankAccount(id);
        model.addAttribute("bankAccount",b);
        return "bankCheck";
    }
    @RequestMapping("/bankAccounts")
    public String getBankAccounts(Model model)
    {
        List<BankAccount> allAccounts = new ArrayList<>(accountService.getAllAccounts());
        model.addAttribute("bankAccounts",allAccounts);
        return "bankAccounts";
    }

    @RequestMapping("/newAccount")
    public String createBankAccount(Model model)
    {
        model.addAttribute("bankAccount",new BankAccount());
        return "bankform";
    }
    @RequestMapping(value="/bankAccounts",method= RequestMethod.POST)
    public String registerAccount(@Valid BankAccount bankAccount, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("There were errors");
            bindingResult.getAllErrors().forEach(error ->
                    {
                        System.out.println(error.getObjectName() + " " + error.getDefaultMessage());
                    }
            );
            return "bankform";
        } else {
            accountService.registerAccount(bankAccount);
            return "redirect:/bankAccounts";
        }
    }
}
