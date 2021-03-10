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

            int maxId = 0;
            int maxCost = 0;
            boolean check = true;

            Purchase [] purchases = new Purchase [6];

            for (int i = 0; i < purchases.length; i++){
                purchases[i] = PurchasesFactory.getPurchaseFromFactory(sc);
                System.out.println(purchases[i]);
                int cost = purchases[i].getCost().getKopecks();
                if(maxCost < cost){
                    maxCost = cost;
                    maxId = i;
                }
                if(!purchases[i].equals(purchases[0])){
                    check=false;
                }
            }
            System.out.println("The purchase with maximum cost:" + purchases[maxId]);

            if(check = true) {
                System.out.println("All purchases are equal");
            } else {
                System.out.println("Not all purchases are equal");
            }

        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }
    }
}
