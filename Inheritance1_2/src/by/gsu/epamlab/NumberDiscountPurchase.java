package by.gsu.epamlab;
import java.util.Scanner;
public class NumberDiscountPurchase extends Purchase{
    private double percentDiscount;
    private final int NUMBER_DISCOUNT = 10;

    public NumberDiscountPurchase(){
    }

    public NumberDiscountPurchase(String name, int price, int number, double percentDiscount) {
        super(name, price,number);
        this.percentDiscount = percentDiscount;
    }
    public NumberDiscountPurchase(Scanner sc){
        super(sc);
        this.percentDiscount = sc.nextDouble();
    }

    @Override
    protected String fieldsToString() {
        return ";" + percentDiscount;
    }


    @Override
    public Byn getCost() {
        if (NUMBER_DISCOUNT < number) {
            return new Byn((int) Math.round(price.getKopecks() * number * (1.0 - percentDiscount / 100.0)));
        } else {
            return super.getCost();
        }
    }
}
