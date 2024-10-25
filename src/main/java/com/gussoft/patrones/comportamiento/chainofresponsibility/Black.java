package com.gussoft.patrones.comportamiento.chainofresponsibility;

public class Black implements ApproveLoanChain{

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
    if (credit > 50000) {
      System.out.println("Esta Solicitud de tarjeta de credito la maneja la BLACK");
    } else {
      next.creditCardRequest(credit);
    }
  }
}
