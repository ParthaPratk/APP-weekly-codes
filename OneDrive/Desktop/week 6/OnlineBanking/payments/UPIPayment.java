package payments;

public class UPIPayment implements SecurePayment {

    public void pay() {
        System.out.println("UPI Payment successful.");
    }

    public void pay(double amount) {
        System.out.println("UPI Payment of " + amount + " successful.");
    }

    public void verifyPayment() {
        System.out.println("UPI Payment verified.");
    }
}