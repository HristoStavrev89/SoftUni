package solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart;

public class Main {
    public static void main(String[] args) {

        Cart cart = new Cart();

        cart.add(new OrderItem("123", 3));

        Order order = new OnlineOrder(cart, "eMail.com");

        order.getTotalAmount();
    }
}
