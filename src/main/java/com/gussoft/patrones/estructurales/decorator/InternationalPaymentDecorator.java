package com.gussoft.patrones.estructurales.decorator;

public class InternationalPaymentDecorator extends CreditDecorator {
    public InternationalPaymentDecorator(Credit decorator) {
        super(decorator);
    }

    @Override
    public void showCredit() {
        decorator.showCredit();
        configInternationalPayment();
    }

    private void configInternationalPayment() {
        System.out.println("La tarjeta a sido configurada para pagos Internacionales");
    }
}
