package MortgageCalculatorPackage;

public class Main1 {

    final static byte monthsInYear = 12;
    final static byte percent = 100;

    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Principal: ", 1000, 1000000); //This runs readNumber method casts it as an integer and stores it in principal.
        float annualInterest = (float) Console.readNumber("Annual Interest Rate: ", 1, 30); //This runs readNumber method casts it as a float and stores it in annual interest.
        byte years = (byte) Console.readNumber("Period (Years): ", 1, 30);
        MortgageReport.printMortgage(principal, annualInterest, years);
        MortgageReport.printPaymentSchedule(principal, annualInterest, years);
    }

}

