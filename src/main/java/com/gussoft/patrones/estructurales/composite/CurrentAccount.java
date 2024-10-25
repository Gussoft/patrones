package com.gussoft.patrones.estructurales.composite;

public class CurrentAccount implements AccountComponent {

    private Double amount;
    private String name;

    public CurrentAccount(Double amount, String name) {
        this.amount = amount;
        this.name = name;
    }

    @Override
    public void showAccountName() {
        System.out.println("Cuenta Corriente : " + name);
    }

    @Override
    public Double getAmount() {
        return amount;
    }
}
