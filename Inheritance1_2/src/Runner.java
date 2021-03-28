import by.gsu.epamlab.Purchase;
import by.gsu.epamlab.PurchasesFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        final int PURCHASES_NUMBER = 6;
        final String FILE_PATH = "src/in.txt";

        try (Scanner sc = new Scanner(new FileReader(FILE_PATH))) {
            sc.useLocale(Locale.ENGLISH);

            boolean areEqual = true;

            Purchase[] purchases = new Purchase[PURCHASES_NUMBER];
            Purchase maxCostPurchase = new Purchase();

            for (int i = 0; i < purchases.length; i++) {
                purchases[i] = PurchasesFactory.getPurchaseFromFactory(sc);
                System.out.println(purchases[i]);

                if (maxCostPurchase.getCost().compareTo(purchases[i].getCost()) < 0) {
                    maxCostPurchase = purchases[i];
                }
                if (areEqual) {
                    areEqual = purchases[i].equals(purchases[0]);
                }
            }
            System.out.println("The purchase with maximum cost:" + maxCostPurchase);

            System.out.println(areEqual
                    ? "All purchases are equal"
                    : "All purchases aren't equal");


        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }
    }
}