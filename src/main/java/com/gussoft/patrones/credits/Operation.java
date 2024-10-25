package com.gussoft.patrones.credits;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

public class Operation {
  public static void main(String[] args) {
    double numero = 1;
    BigDecimal prestamo = BigDecimal.valueOf(10500);
    BigDecimal interes = BigDecimal.valueOf(0.127038);
    BigDecimal seguro = BigDecimal.valueOf(60);
    Operation operation = new Operation();
    operation.calculatePrestamo(prestamo,interes,seguro, numero, 19);
    System.out.println(getRandomNumberString());

    BigDecimal consumo = BigDecimal.valueOf(850);
    BigDecimal pay = BigDecimal.valueOf(851);
    System.out.println("Pago Tarjeta " + pagarTarjeta(consumo, pay));
  }

  private static BigDecimal pagarTarjeta(BigDecimal consumo, BigDecimal pay) {
    return new BigDecimal(String.valueOf(consumo.subtract(pay)));
  }

  private static BigDecimal buyTarjeta(BigDecimal pay) {
    BigDecimal tope = BigDecimal.valueOf(1000);
    BigDecimal consumo = BigDecimal.ZERO;
    if (consumo.add(pay).compareTo(tope) <= 0) {

    }
    return consumo;
  }

  public static String getRandomNumberString() {
    Random rnd = new Random();
    int number = rnd.nextInt(99);
    return String.format("%02d", number);
  }
  private BigDecimal calculateMonthlyPayment(BigDecimal loan, double interest, int numberOfMonths) {
    return loan.multiply(BigDecimal.valueOf(interest))
      .divide(BigDecimal.valueOf(1 - Math.pow(1 + interest, -numberOfMonths)), 2, BigDecimal.ROUND_HALF_EVEN);
  }

  public void calculatePrestamo(BigDecimal monto, BigDecimal interes, BigDecimal seguro, double numeroC, int day) {
    BigDecimal c_interes = monto.multiply(interes).multiply(BigDecimal.valueOf(numeroC));
    double monthlyInterestRate = interes.doubleValue() / 12 / 100;
    BigDecimal monthlyPayment = calculateMonthlyPayment(monto, monthlyInterestRate, day);
    BigDecimal interest = monto.multiply(BigDecimal.valueOf(monthlyInterestRate));
    BigDecimal payment = monthlyPayment.subtract(interest);
    BigDecimal c_total = monto.add(c_interes);
    System.out.println("Interes :: " + c_interes);
    System.out.println("c_total = " + c_total);
    System.out.println("numero de cuotas " + numeroC + " :: " + payment);
  }

  public void calculatePrestamo2(BigDecimal monto, BigDecimal interes, BigDecimal seguro, double numeroC, int day) {
    BigDecimal numerador = interes.multiply(BigDecimal.valueOf(Math.pow(1 + interes.doubleValue(), numeroC)));
    BigDecimal denominador = BigDecimal.valueOf(Math.pow(1 + interes.doubleValue(), numeroC) - 1);
    BigDecimal cuota = numerador.divide(denominador);

    System.out.println("cuota mensual " + cuota.multiply(monto));
  }
}

class CreditDetail {
  private int month;
  private LocalDate payment;
  private BigDecimal loan;
  private BigDecimal interest;
  private BigDecimal sure;
  private BigDecimal total;

  public CreditDetail() {
  }

  public CreditDetail(int month, LocalDate payment, BigDecimal loan, BigDecimal interest, BigDecimal sure,
                      BigDecimal total) {
    this.month = month;
    this.payment = payment;
    this.loan = loan;
    this.interest = interest;
    this.sure = sure;
    this.total = total;
  }

  @Override
  public String toString() {
    return "{" +
      "month=" + month +
      ", payment=" + payment +
      ", loan=" + loan +
      ", interest=" + interest +
      ", sure=" + sure +
      ", total=" + total +
      '}';
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public LocalDate getPayment() {
    return payment;
  }

  public void setPayment(LocalDate payment) {
    this.payment = payment;
  }

  public BigDecimal getLoan() {
    return loan;
  }

  public void setLoan(BigDecimal loan) {
    this.loan = loan;
  }

  public BigDecimal getInterest() {
    return interest;
  }

  public void setInterest(BigDecimal interest) {
    this.interest = interest;
  }

  public BigDecimal getSure() {
    return sure;
  }

  public void setSure(BigDecimal sure) {
    this.sure = sure;
  }

  public BigDecimal getTotal() {
    return total;
  }

  public void setTotal(BigDecimal total) {
    this.total = total;
  }
}
