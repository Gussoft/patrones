package com.gussoft.patrones.estructurales.bridge;

public class UnSecureCreditCard implements ICreditCard {

    @Override
    public void realizarPago() {
        System.out.println("Pago realizado SIN SEGURIDAD!");
    }
}
