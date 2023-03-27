package com.example.users.model;
import javax.persistence.*;

@Entity
@Table(name = "creditcard")
public class CreditCard{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer user_id;
    private String card_holder;
    private Integer card_number;
    private String exp_date;
    private Integer cvv;

    public CreditCard(){

    }

    public Integer getUser_id() {
        return user_id;
    }

    public CreditCard(String card_holder, Integer card_number, String exp_date, Integer cvv) {
        this.card_holder = card_holder;
        this.card_number = card_number;
        this.exp_date = exp_date;
        this.cvv = cvv;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getCard_holder() {
        return card_holder;
    }

    public void setCard_holder(String card_holder) {
        this.card_holder = card_holder;
    }

    public Integer getCard_number() {
        return card_number;
    }

    public void setCard_number(Integer card_number) {
        this.card_number = card_number;
    }

    public String getExp_date() {
        return exp_date;
    }

    public void setExp_date(String exp_date) {
        this.exp_date = exp_date;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }
}


