package Onlines.B1;

// Step 1: Define the base Purchase component interface 

interface Purchase {
    double calculatePrice();
}

class BasePurchase implements Purchase {
    private double basePrice;

    public BasePurchase(double basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public double calculatePrice() {
        return basePrice;
    }
}

abstract class PurchaseDecorator implements Purchase {
    protected Purchase purchase;

    public PurchaseDecorator(Purchase purchase) {
        this.purchase = purchase;
    }

    @Override
    public double calculatePrice() {
        return purchase.calculatePrice();
    }

}

class Loyality extends PurchaseDecorator {
    public Loyality(Purchase purchase) {
        super(purchase);
    }

    @Override
    public double calculatePrice() {
        return super.calculatePrice() * 0.9;
    }
}

class Seasonal extends PurchaseDecorator {
    public Seasonal(Purchase purchase) {
        super(purchase);
    }

    @Override
    public double calculatePrice() {
        return Math.max(super.calculatePrice() - 100, 0);
    }
}

class HighValue extends PurchaseDecorator {
    public HighValue(Purchase purchase) {
        super(purchase);
    }

    @Override
    public double calculatePrice() {
        double price = super.calculatePrice();
        if (price > 10000) {
            return price * 0.98;
        }
        return price;
    }
}

public class B1OnlineMain {
    public static void main(String[] args) {
        double basePrice = 12000; // Initial price of the product

        // Create a base purchase
        Purchase purchase = new BasePurchase(basePrice);

        // Apply discounts conditionally
        Purchase discountedPurchase = new Seasonal(new HighValue(new Loyality(purchase)));

        // Calculate final price after all applicable discounts

        double finalPrice = discountedPurchase.calculatePrice();
        System.out.println("Final price after all discounts: " + finalPrice);
    }
}
