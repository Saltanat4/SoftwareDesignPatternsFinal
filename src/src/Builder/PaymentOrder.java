package Builder;

public class PaymentOrder {
    private final int originalPrice;
    private final boolean discountApplied;
    private final int finalPrice;

    public PaymentOrder(int originalPrice, boolean discountApplied, int finalPrice) {
        this.originalPrice = originalPrice;
        this.discountApplied = discountApplied;
        this.finalPrice = finalPrice;
    }
    public int getOriginalPrice() {
        return originalPrice;
    }
    public boolean isDiscountApplied() {
        return discountApplied;
    }
    public int getFinalPrice() {
        return finalPrice;
    }
}