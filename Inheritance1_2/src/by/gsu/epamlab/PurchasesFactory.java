package by.gsu.epamlab;
import java.util.Scanner;


public class PurchasesFactory {
    private static enum PurchaseKind {
        GENERAL_PURCHASE,
        NUMBER_DISCOUNT_PURCHASE,
        PRICE_DISCOUNT_PURCHASE
    }
    public static Purchase getPurchaseFromFactory(Scanner sc) {
        String id = sc.next();
        PurchaseKind kind = PurchaseKind.valueOf(id);
        switch(kind) {
            case GENERAL_PURCHASE :
                return new Purchase(sc);
            case NUMBER_DISCOUNT_PURCHASE :
                return new NumberDiscountPurchase(sc);
            case PRICE_DISCOUNT_PURCHASE:
                return new PriceDiscountPurchase(sc);
            default :
                throw new IllegalArgumentException();
        }
    }
}
