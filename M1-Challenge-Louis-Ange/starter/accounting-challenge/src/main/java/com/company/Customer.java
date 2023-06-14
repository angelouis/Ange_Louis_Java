package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        //sum variable is keeping a running total of all the charges for this customer
        int sum = 0;

        for(AccountRecord ac : getCharges()) {
            sum += ac.getCharge();
        }

        return sum;
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }

    @Override
    public String toString() {
        //update this
        //Returns back a string that includes the customer's ID, name, and balance
        return "The customer ID is " + id + ", their name is " + name + ", and their balance is "+ getBalance();
    }


}
