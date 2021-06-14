package MortgageCalculatorPackage;

import java.text.NumberFormat;

public class MortgageCalculator {
    private final static byte monthsInYear = 12;
    private final static byte percent = 100;

    private int principal;
    private float annualInterest;
    private byte years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateMortgage() {

        float monthlyInterest = getMonthlyInterest();
        int numberOfPayments = years * monthsInYear;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }

    public double calculateRemainingBalance(int numberOfPaymentsMade) {

        float monthlyInterest = getMonthlyInterest();
        int numberOfPayments = getNumberOfPayments();


        double remainingBalance = principal
                * (Math.pow((1 + monthlyInterest), numberOfPayments) - Math.pow((1 + monthlyInterest), numberOfPaymentsMade))
                / ((Math.pow((1 + monthlyInterest), numberOfPayments)) - 1);

        return remainingBalance;

    }

    public double[] getRemainingBalances() {
        var balances = new double[getNumberOfPayments()];
        for (int month = 1; month <= balances.length; month++) {
            balances[month -1] = calculateRemainingBalance(month);
        }
        return balances;
    }

    private int getNumberOfPayments() {
        return years * monthsInYear;
    }

    private float getMonthlyInterest() {
        return annualInterest / percent / monthsInYear;
    }
}
