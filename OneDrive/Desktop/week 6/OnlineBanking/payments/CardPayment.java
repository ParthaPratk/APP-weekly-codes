package payments;

public class CardPayment implements OnlineTransaction {

    public void pay(double amount) {
        System.out.println("Card Payment of " + amount + " successful.");
    }
}

