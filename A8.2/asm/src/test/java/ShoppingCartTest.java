import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {

    @Test
    public void testAddItem() {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("uranium", 100.21);
        cart.addItem("bavarium", 391.91);

        assertEquals(2, cart.getItemCount());
    }

    @Test
    public void testRemoveItem() {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("uranium", 100.21);
        cart.addItem("bavarium", 391.91);

        cart.removeItem("bavarium");

        assertEquals(1, cart.getItemCount());
    }

    @Test
    public void testCalculateTotal() {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("uranium", 100.21);
        cart.addItem("bavarium", 391.91);

        assertEquals(492.12, cart.calculateTotal(), 0.01);
    }
}
