import by.gsu.epamlab.Byn;
import by.gsu.epamlab.Purchase;
import by.gsu.epamlab.PurchasesFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new FileReader("src/in.txt"))) {
            sc.useLocale(Locale.ENGLISH);

            boolean check = true;
            final int PURCHASES_NUMBER = 6;
            Purchase [] purchases = new Purchase [PURCHASES_NUMBER];
            Purchase maxCostPurchase = new Purchase();

            for (int i = 0; i < purchases.length; i++){
                purchases[i] = PurchasesFactory.getPurchaseFromFactory(sc);
                System.out.println(purchases[i]);

                if(maxCostPurchase.getCost().compareTo(purchases[i].getCost()) < 0){
                    maxCostPurchase = purchases[i];
                }
                if(check){
                    check = purchases[i].equals(purchases[0]);
                }
            }
            System.out.println("The purchase with maximum cost:" + maxCostPurchase);

            if(check) {
                System.out.println("All purchases are equal");
            } else {
                System.out.println("All purchases aren't equal");
            }

        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }
    }
}