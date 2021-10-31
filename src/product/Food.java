package product;

public class Food extends PerishableProduct {

    public Food(String name, String brand, double price) {
        super(name, brand, price);
    }

    public String toString() {
        return getName() + " - " + getBrand();
    }
}
