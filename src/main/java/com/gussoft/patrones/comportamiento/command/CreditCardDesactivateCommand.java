package com.gussoft.patrones.comportamiento.command;

public class CreditCardDesactivateCommand implements Command{
  private CreditCard creditCard;

  public CreditCardDesactivateCommand(CreditCard creditCard) {
    this.creditCard = creditCard;
  }

  @Override
  public void execute() {
    creditCard.desactivate();
    creditCard.sendSMSToCustomerDesactivate();

  }
}
