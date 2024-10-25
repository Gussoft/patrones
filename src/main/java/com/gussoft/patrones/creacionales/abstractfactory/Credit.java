package com.gussoft.patrones.creacionales.abstractfactory;

public class Credit implements PaymentMethod {
  @Override
  public String doPayment() {
    return "Pago a Credito!";
  }
}
