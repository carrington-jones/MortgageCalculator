import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte monthsInYear = 12;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Lets calculate your mortgage!");
        System.out.println("How much is your loan amount?");
        System.out.print("Principal Loan Amount: ");
        int principal = scanner.nextInt();
        System.out.println("What is your interest rate?");
        System.out.print("Interest Rate: ");
        float annualInterestRate = scanner.nextFloat();
        System.out.println("How many years is your loan");
        System.out.print("Loan Years: ");
        byte loanYears = scanner.nextByte();
        float monthlyInterestRate = annualInterestRate / 100 / monthsInYear;
        int numberOfPayments = loanYears * monthsInYear;

        double mortgage = principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments) / (Math.pow(1 + monthlyInterestRate, numberOfPayments)));

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String monthlyMortgagePayment = currency.format(mortgage);
        System.out.println("Your monthly mortgage payment is " + monthlyMortgagePayment);



    }
}
