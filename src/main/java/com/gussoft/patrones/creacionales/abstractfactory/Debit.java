package com.gussoft.patrones.creacionales.abstractfactory;

public class Debit implements PaymentMethod{
  @Override
  public String doPayment() {
    return "Pago a Debito!";
  }
}
