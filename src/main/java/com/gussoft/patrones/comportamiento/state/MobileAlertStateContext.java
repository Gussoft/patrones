package com.gussoft.patrones.comportamiento.state;

public class MobileAlertStateContext {

  private MobileAlertState currentState;

  public MobileAlertStateContext() {
    currentState = new Sound();
  }

  public void alert() {
    currentState.alert(this);
  }

  public void setState(MobileAlertState currentState) {
    this.currentState = currentState;
  }
}
