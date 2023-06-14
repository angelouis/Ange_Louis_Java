package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    Customer cus;
    Customer cus1;

    Customer cus2;

    @BeforeEach
    public void setUp(){
        //Adding two positive charges
        cus = new Customer();
        AccountRecord ac1 = new AccountRecord();
        AccountRecord ac2 = new AccountRecord();
        ac1.setCharge(100);
        ac2.setCharge(450);
        ac1.setChargeDate("12-01-2021");
        ac2.setChargeDate("12-03-2021");
        cus.setId(1);
        cus.setName("Test Case");
        cus.getCharges().add(ac1);
        cus.getCharges().add(ac2);

        //Adding one positive charge and one negative
        cus1 = new Customer();
        AccountRecord ac3 = new AccountRecord();
        AccountRecord ac4 = new AccountRecord();
        ac3.setCharge(100);
        ac4.setCharge(-4500);
        ac3.setChargeDate("12-01-2021");
        ac4.setChargeDate("12-03-2021");
        cus1.setId(2);
        cus1.setName("Test Case 1");
        cus1.getCharges().add(ac3);
        cus1.getCharges().add(ac4);

        //Adding two negative charges
        cus2 = new Customer();
        AccountRecord ac5 = new AccountRecord();
        AccountRecord ac6 = new AccountRecord();
        ac5.setCharge(-1002);
        ac6.setCharge(-4503);
        ac5.setChargeDate("12-01-2021");
        ac6.setChargeDate("12-03-2021");
        cus2.setId(3);
        cus2.setName("Test Case 2");
        cus2.getCharges().add(ac5);
        cus2.getCharges().add(ac6);
    }

    @Test
    void testGetBalanceBothPositive() {
        assertEquals(550, cus.getBalance());
    }

    @Test
    void testGetBalanceOnePositive() {
        assertEquals(-4400, cus1.getBalance());
    }

    @Test
    void testGetBalanceBothNegative() {
        assertEquals(-5505, cus2.getBalance());
    }

    @Test
    void testToString() {
        assertEquals("The customer ID is 1, their name is Test Case, and their balance is 550",cus.toString());
    }
}