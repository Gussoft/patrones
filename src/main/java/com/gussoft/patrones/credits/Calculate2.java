package com.gussoft.patrones.credits;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Calculate2 {

  public static void main(String[] args) {
    BigDecimal principal = BigDecimal.valueOf(10500);
    double annualInterestRate = 12.7038; // Tasa de interés anual del 12.7038%
    int numberOfMonths = 12;

    List<MonthlyPayment> payments = calculateLoanPayments(principal, annualInterestRate, numberOfMonths);

    System.out.println("Mes\tMonto a Pagar\tCuota Mensual\tInterés Acumulado");
    for (int i = 0; i < payments.size(); i++) {
      MonthlyPayment payment = payments.get(i);
      System.out.println((i + 1) + "\t$" + payment.getTotalAmount() + "\t$" + payment.getMonthlyPayment() + "\t$" + payment.getInterestAccumulated());
    }
  }

  public static List<MonthlyPayment> calculateLoanPayments(BigDecimal principal, double annualInterestRate, int numberOfMonths) {
    List<MonthlyPayment> payments = new ArrayList<>();
    BigDecimal monthlyInterestRate = BigDecimal.valueOf(annualInterestRate / 12 / 100);
    BigDecimal monthlyPayment = calculateMonthlyPayment(principal, monthlyInterestRate, numberOfMonths);
    BigDecimal interestAccumulated = BigDecimal.ZERO;

    for (int month = 1; month <= numberOfMonths; month++) {
      BigDecimal interestPayment = principal.multiply(monthlyInterestRate);
      principal = principal.subtract(monthlyPayment.subtract(interestPayment));
      interestAccumulated = interestAccumulated.add(interestPayment);
      BigDecimal totalAmount = principal.add(interestAccumulated);

      payments.add(new MonthlyPayment(totalAmount, monthlyPayment, interestAccumulated));
    }

    return payments;
  }

  private static BigDecimal calculateMonthlyPayment(BigDecimal principal, BigDecimal monthlyInterestRate, int numberOfMonths) {
    BigDecimal numerator = monthlyInterestRate.multiply(principal);
    BigDecimal denominator = BigDecimal.valueOf(Math.pow(1 + monthlyInterestRate.doubleValue(), numberOfMonths) - 1);
    return numerator.divide(denominator, 2, RoundingMode.HALF_UP).add(principal);
  }
}

class MonthlyPayment {
  private BigDecimal totalAmount;  // Monto total a pagar (principal + interés acumulado)
  private BigDecimal monthlyPayment;  // Cuota del mes
  private BigDecimal interestAccumulated;  // Interés acumulado hasta el mes actual

  public MonthlyPayment(BigDecimal totalAmount, BigDecimal monthlyPayment, BigDecimal interestAccumulated) {
    this.totalAmount = totalAmount.setScale(2, RoundingMode.HALF_UP);
    this.monthlyPayment = monthlyPayment.setScale(2, RoundingMode.HALF_UP);
    this.interestAccumulated = interestAccumulated.setScale(2, RoundingMode.HALF_UP);
  }

  public BigDecimal getTotalAmount() {
    return totalAmount;
  }

  public BigDecimal getMonthlyPayment() {
    return monthlyPayment;
  }

  public BigDecimal getInterestAccumulated() {
    return interestAccumulated;
  }
}
