package com.example.splitwise.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//No entity -> not going to store transaction in database, only show to the user
public class Transaction {
    private String from;
    private String to;
    private int amount;
    @Override
    public String toString(){
        return from + " should pay " + amount + " to " + to;
    }
    public Transaction(String from, String to, int amount){
        this.from=from;
        this.to=to;
        this.amount=amount;
    }
}
