package com.gussoft.patrones.estructurales.bridge;

public abstract class CreditCard {

    protected ICreditCard card;
    protected CreditCard(ICreditCard card) {
        this.card = card;
    }

    public abstract void realizarPago();
}
