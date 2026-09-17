import java.util.Scanner;

interface Payment {
    void pay(double amount);
}


class CreditCardPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("\nPayment of Rs." + amount +
                           " made using Credit Card.");
        System.out.println("Credit Card payment successful.");
    }
}


class UPIPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("\nPayment of Rs." + amount +
                           " made using UPI.");
        System.out.println("UPI payment successful.");
    }
}


class NetBankingPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("\nPayment of Rs." + amount +
                           " made using Net Banking.");
        System.out.println("Net Banking payment successful.");
    }
}


public class PaymentDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("ONLINE SHOPPING PAYMENT SYSTEM");
        System.out.println("--------------------------------");

        System.out.print("Enter amount to pay: Rs.");
        double amount = sc.nextDouble();

        System.out.println("\nSelect Payment Method");
        System.out.println("1. Credit Card");
        System.out.println("2. UPI");
        System.out.println("3. Net Banking");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        Payment payment;

        switch (choice) {

            case 1:
                payment = new CreditCardPayment();
                payment.pay(amount);
                break;

            case 2:
                payment = new UPIPayment();
                payment.pay(amount);
                break;

            case 3:
                payment = new NetBankingPayment();
                payment.pay(amount);
                break;

            default:
                System.out.println("Invalid payment method.");
        }

        sc.close();
    }
}