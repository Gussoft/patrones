package com.gussoft.patrones.estructurales.bridge;

public class ClassicCreditCard extends CreditCard {

    public ClassicCreditCard(ICreditCard card) {
        super(card);
    }

    @Override
    public void realizarPago() {
        card.realizarPago();
    }
}
