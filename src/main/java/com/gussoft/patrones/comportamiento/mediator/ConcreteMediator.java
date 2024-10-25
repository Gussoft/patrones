package com.gussoft.patrones.comportamiento.mediator;

public class ConcreteMediator implements Mediator {

  private ConcreteColleage user1;
  private ConcreteColleage2 user2;

  public void setUser1(ConcreteColleage colleage) {
    user1 = colleage;
  }

  public void setUser2(ConcreteColleage2 colleage) {
    user2 = colleage;
  }
  @Override
  public void send(String message, Colleage college) {
    if (college == user1) {
      user2.messageReceived(message);
    } else if(college == user2) {
      user1.messageReceived(message);
    }

  }
}
