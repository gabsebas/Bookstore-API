package com.example.users.controller;

import com.example.users.model.CreditCard;
import com.example.users.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CreditCardController {
    @Autowired
    CreditCardRepository creditCardRepository;
    @PostMapping("{username}/card")
    public CreditCard createCreditCard(@RequestBody Map<String,String> body){
        String card_holder = body.get("card_holder");
        Integer card_number = Integer.valueOf(body.get("card_number"));
        String exp_date = body.get("exp_date");
        Integer cvv = Integer.valueOf(body.get("cvv"));
        CreditCard newCreditCard = new CreditCard(card_holder,card_number,exp_date,cvv);

        return creditCardRepository.save(newCreditCard);
    }
}
