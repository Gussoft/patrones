package com.gussoft.patrones.estructurales.decorator;

public class Gold implements Credit {

    @Override
    public void showCredit() {
        System.out.println("El Credito es de 50.000");
    }
}
