import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FridgeTest {

    private Fridge fridge = new Fridge();

    private final String PRODUCT_A = "PRODUCT_A";
    private final String PRODUCT_B = "PRODUCT_B";

    @Test
    void shouldAddItemsToFridge() {
        fridge.put(PRODUCT_A);
        assertTrue(fridge.contains(PRODUCT_A), "Should contain product after addition.");

        fridge.put(PRODUCT_B);
        assertTrue(fridge.contains(PRODUCT_B), "Should contain product after addition.");
    }

    @Test
    void shouldNotPermitHavingDuplicates() {
        fridge.put(PRODUCT_A);
        assertFalse(fridge.put(PRODUCT_A), "Should not permit adding a product twice.");
    }

    @Test
    void shouldAllowRestoringSameProduct() throws NoSuchItemException {
        fridge.put(PRODUCT_A);
        fridge.take(PRODUCT_A);
        fridge.put(PRODUCT_A);
        assertTrue(fridge.contains(PRODUCT_A), "Should allow to re-store (add-take-add) a product.");
    }

    @Test
    void shouldNotRemoveItemOnDuplicateAdd() {
        fridge.put(PRODUCT_A);
        fridge.put(PRODUCT_A);
        assertTrue(fridge.contains(PRODUCT_A), "Should not remove item after duplicate was added");
    }

    @Test
    void shouldThrowExceptionWhenRemovingNotStoredItem() {
        assertThrowsExactly(NoSuchItemException.class,
                () -> fridge.take(PRODUCT_A),
                "Should throw exception when removing item not in storage.");
    }

    @Test
    void shouldThrowExceptionWhenRemovingNotStoredItemWhenFridgeNotEmpty() {
        fridge.put(PRODUCT_A);
        assertThrowsExactly(NoSuchItemException.class,
                () -> fridge.take(PRODUCT_B),
                "Should throw exception when removing item not in storage that is not empty.");
    }
}