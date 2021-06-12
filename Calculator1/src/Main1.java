import java.text.NumberFormat;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {

        int principal = (int) readNumber("Principal: ", 1000, 1000000); //This runs readNumber method casts it as an integer and stores it in principal.
        float annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 30); //This runs readNumber method casts it as a float and stores it in annual interest.
        byte years = (byte) readNumber("Period (Years): ", 1, 30);
        double mortgage = calculateMortgage(principal, annualInterest, years);
//        double remainingBalance = calculateRemaingBalance(principal,annualInterest,years);

//        String remainingBalanceFormatted = NumberFormat.getCurrencyInstance().format(remainingBalance);
//        System.out.println(remainingBalanceFormatted);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
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

    public static double calculateRemaingBalance(int principal, float annualInterest, byte years) {
        byte monthsInYear = 12;
        byte percent = 100;
        float monthlyInterest = annualInterest / percent / monthsInYear;
        int numberOfPayments = years * monthsInYear;
        int numberOfPaymentMade = 1;
        double remainingBalance = principal
                * (Math.pow((1 + monthlyInterest),(numberOfPayments)) - Math.pow((1 + monthlyInterest), numberOfPaymentMade))
                / ((Math.pow((1 + monthlyInterest),numberOfPayments)) - 1);
        return remainingBalance;



    }

    public static double calculateMortgage(int principal, float annualInterest, byte years) {

         byte monthsInYear = 12;
         byte percent = 100;
        float monthlyInterest = annualInterest / percent / monthsInYear;
        int numberOfPayments = years * monthsInYear;
        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }

}

