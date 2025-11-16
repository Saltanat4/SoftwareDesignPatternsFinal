package Builder;

public class PaymentOrderBuilder {
    private int originalPrice;
    private boolean discountApplied = false;
    private int finalPrice;

    public PaymentOrderBuilder setOriginalPrice(int price) {
        this.originalPrice = price;
        this.finalPrice = price;
        return this;
    }
    public PaymentOrderBuilder applyDiscount() {
        this.discountApplied = true;
        this.finalPrice = (int)(originalPrice * 0.9);
        return this;
    }
    public PaymentOrder build() {
        return new PaymentOrder(originalPrice, discountApplied, finalPrice);
    }
}