package shop;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Cashier {

    public void printReceipt(Cart cart, LocalDateTime purchaseDateTime){
        DecimalFormat df = new DecimalFormat("#.##");
        double subTotal = 0;
        double totalDiscount = 0;
        double total;
        System.out.println("Date: " + purchaseDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println();
        System.out.println("---Products---");
        System.out.println();
        List<CartItem> cartItemList = cart.getCart();

        for (CartItem cartItem : cartItemList) {
            double itemSubtotal = cartItem.getProduct().getPrice();
            String itemDiscountPercentage = cartItem
                    .getProduct()
                    .getDiscount(purchaseDateTime.toLocalDate())
                    .getDiscountPercentage();
            double itemTotal = itemSubtotal * cartItem.getQuantity();
            double itemQuantity = cartItem.getQuantity();
            double itemDiscount = cartItem
                    .getProduct()
                    .getDiscount(purchaseDateTime.toLocalDate())
                    .getDiscountValue() * itemQuantity;

            subTotal = subTotal + itemSubtotal * cartItem.getQuantity();
            totalDiscount = totalDiscount + itemDiscount;

            System.out.println(cartItem.getProduct().toString());
            System.out.println(df.format(itemQuantity) + " x " + "$" + df.format(itemSubtotal) + " = " + "$" + df.format(itemTotal));
            if (itemDiscount != 0) {
                System.out.println("#discount " + itemDiscountPercentage + " " + "-$" + df.format(itemDiscount));
            }
            System.out.println();
        }

        total = subTotal - totalDiscount;
        System.out.println("SUBTOTAL: $" + df.format(subTotal));
        System.out.println("DISCOUNT: -$" + df.format(totalDiscount));
        System.out.println();
        System.out.println("TOTAL: $" + df.format(total));
    }
}
