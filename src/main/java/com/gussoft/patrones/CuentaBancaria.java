package com.gussoft.patrones;

public class CuentaBancaria {
  private String IbanCliente;

  public CuentaBancaria() {
  }

  public String getIbanCliente() {
    return IbanCliente;
  }

  public void setIbanCliente(String ibanCliente) {
    IbanCliente = ibanCliente;
  }

  @Override
  public String toString() {
    return "{" +
      "IbanCliente='" + IbanCliente + '\'' +
      '}';
  }
}
