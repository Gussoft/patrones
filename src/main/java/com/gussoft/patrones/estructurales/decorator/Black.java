package com.gussoft.patrones.estructurales.decorator;

public class Black implements Credit {

    @Override
    public void showCredit() {
        System.out.println("El Credito es de 1.000.000");
    }
}
