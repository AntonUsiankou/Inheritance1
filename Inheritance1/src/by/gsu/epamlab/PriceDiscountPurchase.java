package by.gsu.epamlab;
import java.util.Scanner;

public class PriceDiscountPurchase extends Purchase{

    private Byn priceDiscount;

    public PriceDiscountPurchase(){
    }

    public PriceDiscountPurchase(String name, int price, int number, int priceDiscount ){
        super(name, price, number);
        this.priceDiscount = new Byn(priceDiscount);
    }
    public PriceDiscountPurchase(Scanner sc){
        super (sc);
        this.priceDiscount = new Byn(sc.nextInt());
    }

    @Override
    protected String fieldsToString() {
        return  ";" + priceDiscount;
    }

    @Override
    public Byn getCost() {
        Byn cost = new Byn(getPrice());
        return cost.sub(priceDiscount).mul(getNumber());
    }
}
