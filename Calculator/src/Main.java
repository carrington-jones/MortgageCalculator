import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lets calculate your mortgage!");
        System.out.println("How much is your loan amount?");
        System.out.print("Principal: ");
        int principal = scanner.nextInt();
        System.out.println("What is your interest rate?");
        System.out.print("Interest Rate: ");
        double intRate = scanner.nextDouble();
        System.out.println("How many years is your loan");
        System.out.print("Loan Years: ");
        int loanYears = scanner.nextInt();
        double monthlyInterestRate = ((intRate / 100) / 12);
        int numberOfPayments = (loanYears * 12);
        double topHalf1 = (1 + monthlyInterestRate);
        double topHalf2 = Math.pow(topHalf1,numberOfPayments);
        double topHalf3 = monthlyInterestRate * topHalf2;
        double bottomHalf1 = 1 + monthlyInterestRate;
        double bottomHalf2 = Math.pow(bottomHalf1,numberOfPayments);
        double bottomHalf3 = bottomHalf2 - 1;
        double lastPart = (topHalf3 / bottomHalf3);
        double monthlyPayment = principal * lastPart;
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String monthlyPaymentDollars = currency.format(monthlyPayment);
        System.out.println("Your monthly mortgage payment is " + monthlyPaymentDollars);



    }
}
