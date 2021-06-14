package MortgageCalculatorPackage;

import java.text.NumberFormat;

public class MortgageReport {

    private static MortgageCalculator calculator;

    static void printMortgage(int principal, float annualInterest, byte years) {
        calculator = new MortgageCalculator(principal, annualInterest, years);
        double mortgage = calculator.calculateMortgage();
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("Mortgage");
        System.out.println("---------");
        System.out.println("Mortgage: " + mortgageFormatted);
    }

    static void printPaymentSchedule(int principal, float annualInterest, byte years) {
        System.out.println();
        System.out.println("Payment Schedule");
        System.out.println("---------");
        for (int month = 1; month <= years * Main1.monthsInYear; month++) {
            double balance = new MortgageCalculator().calculateRemainingBalance(month);
            String remainingBalanceFormatted = NumberFormat.getCurrencyInstance().format(balance);
            System.out.println(remainingBalanceFormatted);
        }
    }
}
