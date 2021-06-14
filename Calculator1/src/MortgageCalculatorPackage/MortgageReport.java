package MortgageCalculatorPackage;

import java.text.NumberFormat;

public class MortgageReport {

    private final NumberFormat currency;
    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("Payment Schedule");
        System.out.println("---------");

        for (double balance : calculator.getRemainingBalances()) {
            String remainingBalanceFormatted = currency.format(balance);
            System.out.println(remainingBalanceFormatted);
        }
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String mortgageFormatted = currency.format(mortgage);
        System.out.println();
        System.out.println("Mortgage");
        System.out.println("---------");
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}
