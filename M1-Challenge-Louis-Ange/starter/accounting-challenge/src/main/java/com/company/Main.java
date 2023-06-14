package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static void main(String[] args) {

        List<Customer> customerList = new ArrayList<>();

        //https://www.geeksforgeeks.org/set-in-java/
        // Using a set so duplicate customers are not created
        Set<String> hash_Set = new HashSet<String>();

        for (String[] row : customerData) {
            //If the customer ID is not in the set then it hasn't been created yet and it needs to be added
            // to the customerList array
            if(hash_Set.contains(row[0]) == false) {
                hash_Set.add(row[0]);
                Customer newCustomer = new Customer();
                newCustomer.setId(Integer.parseInt(row[0]));
                newCustomer.setName(row[1]);

                // https://xperti.io/blogs/modulo-modulus-remainder-operator-in-java/
                //Using modulo so the customer has a specific place in the array to easily
                // keep track of it for adding records to the object
                customerList.add(customerData.size() % Integer.parseInt(row[0]), newCustomer );
            }

            //Retrieving the customer if already in the list and adding a charge to it
            Customer specificCustomer = customerList.get(customerData.size() % Integer.parseInt(row[0]));
            AccountRecord newAccountRecord = new AccountRecord();
            newAccountRecord.setCharge(Integer.parseInt(row[2]));
            newAccountRecord.setChargeDate(row[3]);
            specificCustomer.getCharges().add(newAccountRecord);

        }


        //Printing out customer information
        for(Customer c : customerList){
            System.out.println(c.toString());

        }

        // Negative Balance Accounts
        List<Customer> negBal = new ArrayList<>();
        for (Customer c : customerList){
            if (c.getBalance() < 0) {
                negBal.add(c);
            }
        }

        // Positive Balance Accounts
        List<Customer> posBal = new ArrayList<>();
        for (Customer c : customerList){
            if (c.getBalance() >= 0) {
                posBal.add(c);
            }
        }

        //Printing out positive and negative accounts
        System.out.println("Positive accounts:" + posBal.toString());
        System.out.println("Negative accounts:" + negBal.toString());
    }
}
