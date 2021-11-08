import product.*;
import shop.Cart;
import shop.Cashier;
import java.time.LocalDateTime;

public class Store {

    public static void main(String[] args) {
        Product apples = new Food("apples", "BrandA", 1.50);
        Product beer = new Beverage("beer", "BrandB", 2.97);
        Product tshirt = new Clothes("T-Shirt", "BrandC", 15.99, Clothes.Size.M, "violet");
        Product laptop = new Appliance("ASUS", "BrandD", 2345, "ModelL", 1.25);

        Cart cart = new Cart();
        cart.addToCart(laptop, 1);
        cart.addToCart(tshirt, 2);
        cart.addToCart(beer, 3);
        cart.addToCart(apples, 2.45);
        Cashier cashier = new Cashier();
        cashier.printReceipt(cart, LocalDateTime.now());
    }
}
