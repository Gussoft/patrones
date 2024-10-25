package com.gussoft.patrones.comportamiento.chainofresponsibility;

public interface ApproveLoanChain {

  void setNext(ApproveLoanChain loan);

  ApproveLoanChain getNext();

  void creditCardRequest(int credit);

}
