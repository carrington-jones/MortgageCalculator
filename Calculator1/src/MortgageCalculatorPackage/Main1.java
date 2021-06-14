package MortgageCalculatorPackage;

import java.text.NumberFormat;

public class Main1 {

    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Principal: ", 1000, 1000000); //This runs readNumber method casts it as an integer and stores it in principal.
        float annualInterest = (float) Console.readNumber("Annual Interest Rate: ", 1, 30); //This runs readNumber method casts it as a float and stores it in annual interest.
        byte years = (byte) Console.readNumber("Period (Years): ", 1, 30);



        var calculator = new MortgageCalculator(principal, annualInterest, years);
        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }

}

