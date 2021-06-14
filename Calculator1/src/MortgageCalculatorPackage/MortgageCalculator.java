package MortgageCalculatorPackage;

public class MortgageCalculator {
    private int principal;
    private float annualInterest;
    private byte years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateMortgage() {

        float monthlyInterest = annualInterest / Main1.percent / Main1.monthsInYear;
        int numberOfPayments = years * Main1.monthsInYear;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }

    public double calculateRemainingBalance(int numberOfPaymentsMade) {

        float monthlyInterest = annualInterest / Main1.percent / Main1.monthsInYear;
        int numberOfPayments = years * Main1.monthsInYear;


        double remainingBalance = principal
                * (Math.pow((1 + monthlyInterest), numberOfPayments) - Math.pow((1 + monthlyInterest), numberOfPaymentsMade))
                / ((Math.pow((1 + monthlyInterest), numberOfPayments)) - 1);

        return remainingBalance;

    }
}
