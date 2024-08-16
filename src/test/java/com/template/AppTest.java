package com.template;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.template.App.deposit;
import static com.template.App.extract;
import static com.template.App.transfer;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    void testDeposit() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati", 10);
        accounts.put("juan", 20);
        Map<String, Integer> updatedAccounts = deposit(accounts, "mati", 5);
        assertEquals(15, updatedAccounts.get("mati"));
    }

    @Test
    void testNegativeDeposit() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati", 10);
        accounts.put("juan", 20);
        Map<String, Integer> updatedAccounts = deposit(accounts, "mati", -5);
        assertEquals(10, updatedAccounts.get("mati"));
    }

    @Test
    void testNonExistentDeposit() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati", 10);
        accounts.put("juan", 20);
        Map<String, Integer> updatedAccounts = deposit(accounts, "tomi", 10);
        assertEquals(10, updatedAccounts.get("mati"));
    }

    @Test
    void testExtractDeposit() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati", 10);
        accounts.put("juan", 20);
        Map<String, Integer> updatedAccounts = extract(accounts, "mati", 5);
        assertEquals(5, updatedAccounts.get("mati"));

    }

    @Test
    void testNegativeExtract() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati", 10);
        accounts.put("juan", 20);
        Map<String, Integer> updatedAccounts = extract(accounts, "mati", -5);
        assertEquals(10, updatedAccounts.get("mati"));
    }

    @Test
    void testNonExistentBalance() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati", 0);
        accounts.put("juan", 20);
        Map<String, Integer> updatedAccounts = extract(accounts, "mati", 5);
        assertEquals(0, updatedAccounts.get("mati"));

    }

    @Test
    void testNonExistentExtract() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati", 0);
        accounts.put("juan", 20);
        Map<String, Integer> updatedAccounts = extract(accounts, "tomi", 5);
        assertEquals(0, updatedAccounts.get("mati"));
    }

    @Test
    void testTransfer() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati", 10);
        accounts.put("juan", 20);
        Map<String, Integer> updatedAccounts = transfer(accounts, "mati", "juan", 5);
        assertEquals(5, updatedAccounts.get("mati"));
        assertEquals(25, updatedAccounts.get("juan"));
    }
    @Test
    void testNonExistentBothBalances1(){
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati", 0);
        accounts.put("juan", 20);
        Map<String, Integer> updatedAccounts = transfer(accounts, "mati", "juan", 5);
        assertEquals(0, updatedAccounts.get("mati"));
        assertEquals(20, updatedAccounts.get("juan"));
    }
    @Test
    void testNonexistentBalance1(){
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati", 20);
        accounts.put("juan", 10);
        Map<String, Integer> updatedAccounts = transfer(accounts, "tomi", "mati", 5);
        assertEquals(20, updatedAccounts.get("mati"));
        assertEquals(10, updatedAccounts.get("juan"));
    }
    @Test
    void testNonexistentBalance2(){
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati", 20);
        accounts.put("juan", 10);
        Map<String, Integer> updatedAccounts = transfer(accounts, "mati", "tomi", 5);
        assertEquals(20, updatedAccounts.get("mati"));
        assertEquals(10, updatedAccounts.get("juan"));
    }
    @Test
    void testNegativeBalance(){
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati", 10);
        accounts.put("juan", 20);
        Map<String, Integer> updatedAccounts = transfer(accounts, "mati", "juan", -5);
        assertEquals(10, updatedAccounts.get("mati"));
        assertEquals(20, updatedAccounts.get("juan"));
    }
    @Test
    void testSameAccountTransfer(){
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati", 10);
        accounts.put("juan", 20);
        Map<String, Integer> updatedAccounts = transfer(accounts, "mati", "mati", 5);
        assertEquals(10, updatedAccounts.get("mati"));

    }
}

