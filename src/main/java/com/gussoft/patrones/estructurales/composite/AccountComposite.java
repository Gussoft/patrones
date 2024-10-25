package com.gussoft.patrones.estructurales.composite;

import java.util.ArrayList;
import java.util.List;

public class AccountComposite implements AccountComponent {

    private List<AccountComponent> childAccounts;

    public AccountComposite() {
        this.childAccounts = new ArrayList<>();
    }

    @Override
    public void showAccountName() {
        for (AccountComponent account: childAccounts) {
            account.showAccountName();
        }
    }

    @Override
    public Double getAmount() {
        Double totalAmount = 0.0;
        for (AccountComponent account: childAccounts) {
            totalAmount += account.getAmount();
        }
        System.out.println("la cuenta tiene un total de: " + totalAmount);
        return totalAmount;
    }

    public void addAccount(AccountComponent account) {
        childAccounts.add(account);
    }

    public void removeAccount(AccountComponent account) {
        childAccounts.remove(account);
    }
}
