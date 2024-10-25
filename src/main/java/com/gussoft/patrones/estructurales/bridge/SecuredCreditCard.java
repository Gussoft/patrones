package com.gussoft.patrones.estructurales.bridge;

public class SecuredCreditCard implements ICreditCard {

    @Override
    public void realizarPago() {
        System.out.println("Pago Realizado CON SEGURIDAD");
    }
}
