import java.text.NumberFormat;
import java.util.Scanner;

public class Main1 {

    final static byte monthsInYear = 12;
    final static byte percent = 100;

    public static void main(String[] args) {
        int principal = (int) readNumber("Principal: ", 1000, 1000000); //This runs readNumber method casts it as an integer and stores it in principal.
        float annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 30); //This runs readNumber method casts it as a float and stores it in annual interest.
        byte years = (byte) readNumber("Period (Years): ", 1, 30);
        printMortgage(principal, annualInterest, years);
        printPaymentSchedule(principal, annualInterest, years);
    }

    private static void printMortgage(int principal, float annualInterest, byte years) {
        double mortgage = calculateMortgage(principal, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("Mortgage");
        System.out.println("---------");
        System.out.println("Mortgage: " + mortgageFormatted);
    }

    private static void printPaymentSchedule(int principal, float annualInterest, byte years) {
        System.out.println();
        System.out.println("Payment Schedule");
        System.out.println("---------");
        for (int month = 1; month <= years * monthsInYear; month++) {
            double balance = calculateRemainingBalance(principal, annualInterest, years, month);
            String remainingBalanceFormatted = NumberFormat.getCurrencyInstance().format(balance);
            System.out.println(remainingBalanceFormatted);
        }
    }

    public static double readNumber(String prompt, double min, double max) {
        double value;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print(prompt);
            value = scanner.nextFloat();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between" + min + "and" + max);
        }
        return value;
    }

    public static double calculateRemainingBalance(int principal, float annualInterest, byte years, int numberOfPaymentsMade) {

        float monthlyInterest = annualInterest / percent / monthsInYear;
        int numberOfPayments = years * monthsInYear;


        double remainingBalance = principal
                * (Math.pow((1 + monthlyInterest), numberOfPayments) - Math.pow((1 + monthlyInterest), numberOfPaymentsMade))
                / ((Math.pow((1 + monthlyInterest), numberOfPayments)) - 1);

        return remainingBalance;

    }

    public static double calculateMortgage(int principal, float annualInterest, byte years) {

        float monthlyInterest = annualInterest / percent / monthsInYear;
        int numberOfPayments = years * monthsInYear;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }

}

