package product;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Appliance extends Product {

    private String model;
    private LocalDate productionDate;
    private double weight;

    public Appliance(String name, String brand, double price, String model, double weight) {
        super(name, brand, price);
        this.model = model;
        this.weight = weight;
        this.productionDate = setProductionDate();
    }

    public String getModel() {
        return model;
    }

    private LocalDate setProductionDate() {
        int months = (int) (Math.random() + 48);
        return LocalDate.now().minusMonths(months);
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public String getWeight() {
        return weight + " kg";
    }

    public Discount getDiscount(LocalDate dateOfPurchase) {
        double discount = 0;
        if ((dateOfPurchase.getDayOfWeek() == DayOfWeek.SATURDAY
                || dateOfPurchase.getDayOfWeek() == DayOfWeek.SUNDAY)
                && getPrice() > 999) {
            discount = getPrice() * 0.05;
        }
        return new Discount("5%", discount);
    }

    public String toString() {
        return super.toString() + " " + getModel();
    }
}
