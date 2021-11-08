package product;

import java.time.LocalDate;
import java.time.Period;

public class PerishableProduct extends Product {

    private LocalDate expirationDate;

    public PerishableProduct(String name, String brand, double price) {
        super(name, brand, price);
        this.expirationDate = setExpirationDate();
    }

    private LocalDate setExpirationDate() {
        int days = (int)(Math.random() * 8);
        return LocalDate.now().plus(Period.ofDays(days));
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public Discount getDiscount(LocalDate dateOfPurchase) {
        double discount = 0;
        String discountPercentage = "";
        if (dateOfPurchase.isEqual(expirationDate)) {
            discount = getPrice() * 0.5;
            discountPercentage = "50%";
        } else {
            int days = Period.between(dateOfPurchase, expirationDate).getDays();
            if (days <= 5) {
                discount = getPrice() * 0.1;
                discountPercentage = "10%";
            }
        }
        return new Discount(discountPercentage, discount);
    }
}
