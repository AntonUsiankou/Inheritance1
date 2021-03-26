package by.gsu.epamlab;

import java.util.Objects;
import java.util.Scanner;

public class Purchase {
    private String name;
    private Byn price;
    private int number;

    public Purchase() {
        this.price = new Byn();
    }

    public Purchase(String name, int price, int number){
        super();
        this.name = name;
        this.price = new Byn(price);
        this.number = number;
    }

    public Purchase (Scanner sc){
        this.name = sc.next();
        this.price = new Byn(sc.nextInt());
        this.number = sc.nextInt();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Byn getPrice() {
        return price;
    }
    public void setPrice(Byn price) {
        this.price = price;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public Byn getCost() {
        return new Byn(price).mul(number);
    }

    protected String fieldsToString() {
        return name + ";" + price + ";" + number;
    }

    @Override
    public String toString() {
        return fieldsToString() + ";" + getCost();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase)) return false;
        Purchase purchase = (Purchase) o;

        return name.equals(purchase.name) &&
                price.equals(purchase.price);
    }
}