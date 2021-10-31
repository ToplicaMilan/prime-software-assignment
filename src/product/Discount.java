package product;

public class Discount{
    private String discountPercentage;
    private double discountValue;

    public Discount(String discountPercentage, double discountValue) {
        this.discountPercentage = discountPercentage;
        this.discountValue = discountValue;
    }

    public String getDiscountPercentage() {
        return discountPercentage;
    }

    public double getDiscountValue() {
        return discountValue;
    }
}
