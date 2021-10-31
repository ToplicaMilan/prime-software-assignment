package product;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Clothes extends Product {

    private Size size;
    private String colour;

    public Clothes(String name, String brand, double price, Size size, String colour) {
        super(name, brand, price);
        this.size = size;
        this.colour = colour;
    }

    public Size getSize() {
        return size;
    }

    public String getColour() {
        return colour;
    }

    public Discount getDiscount(LocalDate dateOfPurchase) {
        double discount = 0;
        if (dateOfPurchase.getDayOfWeek() != DayOfWeek.SATURDAY
                && dateOfPurchase.getDayOfWeek() != DayOfWeek.SUNDAY) {
            discount = getPrice() * 0.1;
        }
        return new Discount("10%", discount);
    }

    public String toString() {
        return super.toString() + " " + getSize() + " " + getColour();
    }

    public enum Size {
        XS, S, M, L, XL
    }
}
