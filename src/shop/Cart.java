package shop;

import product.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> cart = new ArrayList<>();

    public List<CartItem> getCart() {
        return cart;
    }

    public void addToCart(Product product, double quantity) {
        cart.add(new CartItem(product, quantity));
    }
}
