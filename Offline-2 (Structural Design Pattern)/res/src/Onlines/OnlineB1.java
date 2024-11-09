package Onlines;

// Step 1: Define the base Purchase component interface 

interface Purchase {
    double calculatePrice();
}

class DiscountDecorator implements Purchase {
    protected Purchase purchase;

    public DiscountDecorator(double price) {
        this.purchase = new Purchase() {
            @Override
            public double calculatePrice() {
                return price;
            }
        };
    }

    public DiscountDecorator(Purchase purchase) {
        this.purchase = purchase;
    }

    @Override
    public double calculatePrice() {
        return purchase.calculatePrice();
    }
}

class LoyaltyDiscount extends DiscountDecorator {
    public LoyaltyDiscount(Purchase purchase) {
        super(purchase);
    }

    @Override
    public double calculatePrice() {
        return super.calculatePrice() * 0.9;
    }
}

class SeasonalDiscount extends DiscountDecorator {
    public SeasonalDiscount(Purchase purchase) {
        super(purchase);
    }

    @Override
    public double calculatePrice() {
        return Math.max(super.calculatePrice() - 100, 0);
    }
}

class HighValueDiscount extends DiscountDecorator {
    public HighValueDiscount(Purchase purchase) {
        super(purchase);
    }

    @Override
    public double calculatePrice() {
        double basePrice = super.calculatePrice();
        if (basePrice > 10000) {
            return basePrice * 0.98;
        }
        return basePrice;
    }
}

public class OnlineB1 {
    public static void main(String[] args) {
        double basePrice = 12000; // Initial price of the product

        // Create a base purchase
        Purchase purchase = new Purchase() {
            @Override
            public double calculatePrice() {
                return basePrice;
            }
        };

        // Apply discounts conditionally
        Purchase discountedPurchase = new SeasonalDiscount(new HighValueDiscount(new LoyaltyDiscount(purchase)));

        // Calculate final price after all applicable discounts

        double finalPrice = discountedPurchase.calculatePrice();
        System.out.println("Final price after all discounts: " + finalPrice);
    }
}
