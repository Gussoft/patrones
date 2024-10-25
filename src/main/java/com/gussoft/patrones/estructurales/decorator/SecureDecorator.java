package com.gussoft.patrones.estructurales.decorator;

public class SecureDecorator extends CreditDecorator {

    public SecureDecorator(Credit decorator) {
        super(decorator);
    }

    @Override
    public void showCredit() {
        decorator.showCredit();
        configSecure();
    }

    private void configSecure() {
        System.out.println("La Tarjeta ha sido configurada con maxima Seguridad");
    }
}
