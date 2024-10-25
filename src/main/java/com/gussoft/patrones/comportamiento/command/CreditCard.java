package com.gussoft.patrones.comportamiento.command;

public class CreditCard {

  public void sendPinNumberToCustomer() {
    System.out.println("El pin number ha sido envial al cliente");
  }

  public void sendSMSToCustomerActivate() {
    System.out.println("enviando SMS al cliente informando que su tarjeta a sido activada.");
  }

  public void activate() {
    System.out.println("su tarjeta a sido activada");
  }

  public void desactivate() {
    System.out.println("su tarjeta a sido desactivada");
  }

  public void sendSMSToCustomerDesactivate() {
    System.out.println("enviando SMS al cliente informando que su tarjeta a sido desactivada.");
  }

}
