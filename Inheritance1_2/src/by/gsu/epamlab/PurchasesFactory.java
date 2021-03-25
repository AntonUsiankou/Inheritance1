package by.gsu.epamlab;
import java.util.Scanner;


public class PurchasesFactory {
    private static enum PurchaseKind {
        GENERAL_PURCHASE{
            Purchase getPurchase(Scanner sc){
                return new Purchase(sc);
            }
        },
        PERCENT_DISCOUNT_PURCHASE{
            Purchase getPurchase(Scanner sc){
                return new PercentDiscountPurchase(sc);
            }
        },
        PRICE_DISCOUNT_PURCHASE{
            Purchase getPurchase(Scanner sc){
                return new PriceDiscountPurchase(sc);
            }

        };
        abstract Purchase getPurchase(Scanner sc);
    }
    public static Purchase getPurchaseFromFactory(Scanner sc) {
        String id = sc.next();
        return PurchaseKind.valueOf(id).getPurchase(sc);
    }

}
