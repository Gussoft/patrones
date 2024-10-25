package com.gussoft.patrones.estructurales.decorator;

public class CreditDecorator implements Credit {

    protected Credit decorator;

    public CreditDecorator(Credit decorator) {
        this.decorator = decorator;
    }

    @Override
    public void showCredit() {
        decorator.showCredit();
    }
}
