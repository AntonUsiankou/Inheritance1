package by.gsu.epamlab;

import java.util.Scanner;

public class PriceDiscountPurchase extends Purchase {

    private Byn kopeckDiscount;

    public PriceDiscountPurchase() {
    }

    public PriceDiscountPurchase(String name, int price, int number, int priceDiscount) {
        super(name, price, number);
        this.kopeckDiscount = new Byn(priceDiscount);
    }

    public PriceDiscountPurchase(Scanner sc) {
        super(sc);
        this.kopeckDiscount = new Byn(sc.nextInt());
    }

    public Byn getKopeckDiscount() {
        return kopeckDiscount;
    }

    public void setKopeckDiscount(Byn kopeckDiscount) {
        this.kopeckDiscount = kopeckDiscount;
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + kopeckDiscount;
    }

    @Override
    public Byn getCost() {
        return new Byn(getPrice()).subtraction(kopeckDiscount).multiply(getNumber());
    }
}