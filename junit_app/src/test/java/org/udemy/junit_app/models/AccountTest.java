package org.udemy.junit_app.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void AccountNameTest() {
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

}