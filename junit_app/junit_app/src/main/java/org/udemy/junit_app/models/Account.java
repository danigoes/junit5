package org.udemy.junit_app.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String person;
    private BigDecimal balance;

    public void debit(BigDecimal value) {
        BigDecimal newBalance = this.balance.subtract(value);
        this.balance = newBalance;
    }

    public void credit(BigDecimal value) {
        this.balance = this.balance.add(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Account)) {
            return false;
        }
        Account c = (Account) obj;
        if (this.person == null || this.balance == null) {
            return false;
        }
        return this.person.equals(c.getPerson()) && this.balance.equals(c.getBalance());
    }
}
