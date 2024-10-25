package com.gussoft.patrones.comportamiento.chainofresponsibility;

public class Gold implements ApproveLoanChain{

  private ApproveLoanChain next;

  @Override
  public void setNext(ApproveLoanChain loan) {
    next = loan;
  }

  @Override
  public ApproveLoanChain getNext() {
    return next;
  }

  @Override
  public void creditCardRequest(int credit) {
    if (credit <= 10000) {
      System.out.println("Esta Solicitud de tarjeta de credito la maneja la GOLD");
    } else {
      next.creditCardRequest(credit);
    }
  }
}
