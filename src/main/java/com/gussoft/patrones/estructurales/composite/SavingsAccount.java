package com.gussoft.patrones.estructurales.composite;

public class SavingsAccount implements AccountComponent {

    private Double amount;
    private String name;

    public SavingsAccount(Double amount, String name) {
        this.amount = amount;
        this.name = name;
    }

    @Override
    public void showAccountName() {
        System.out.println("Cuenta de Ahorro : " + name);
    }

    @Override
    public Double getAmount() {
        return amount;
    }
}
