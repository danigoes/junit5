package org.udemy.junit_app.models;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void accountNameTest() {
        Account account = new Account();
        account.setPerson("Andres");
        String expected = "Andres";
        String actual = account.getPerson();
        assertEquals(expected, actual); // Capitulo 8
        /*assertNotNull(actual, () -> "la cuenta no puede ser nula");
        assertEquals(expected, actual, () -> "el nombre de la cuenta no es el que se esperaba: se esperaba " + expected
                + " sin embargo fue " + actual);
        assertTrue(actual.equals("Andres"), () -> "nombre cuenta esperada debe ser igual a la real");*/
    }

    @Test
    void accountBalanceTest() {
        Account account = new Account("Andres", new BigDecimal("1000.12345"));
        assertNotNull(account.getBalance());
        assertEquals(1000.12345, account.getBalance().doubleValue());
        assertFalse(account.getBalance().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(account.getBalance().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void accountReferenceTest() {
        Account account = new Account("John Doe", new BigDecimal("8900.9997"));
        Account account2 = new Account("John Doe", new BigDecimal("8900.9997"));

//        assertNotEquals(cuenta2, cuenta);
        assertEquals(account, account2);
    }

    @Test
    void debitAccountTest() {
        Account account = new Account("John Doe", new BigDecimal("1000.12345"));
        account.debit(new BigDecimal(100));
        assertNotNull(account.getBalance());
        assertEquals(900, account.getBalance().intValue());
        assertEquals("900.12345", account.getBalance().toPlainString());
    }

    @Test
    void creditAccountTest() {
        Account account = new Account("John Doe", new BigDecimal("1000.12345"));
        account.credit(new BigDecimal(100));
        assertNotNull(account.getBalance());
        assertEquals(1100, account.getBalance().intValue());
        assertEquals("1100.12345", account.getBalance().toPlainString());
    }

}