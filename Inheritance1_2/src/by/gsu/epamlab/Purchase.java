package by.gsu.epamlab;

import java.util.Objects;
import java.util.Scanner;

public class Purchase {
    protected String name;
    protected Byn price;
    protected int number;

    public Purchase() {}

    public Purchase(String name, int price, int number){
        super();
        this.name = name;
        this.price = new Byn(price);
        this.number = number;
    }

    //CONSTRUCTOR FOR SCANNER
    public Purchase (Scanner sc){
        this.name = sc.next();
        this.price = new Byn(sc.nextInt());
        this.number = sc.nextInt();
    }

    public Byn getCost(){
        return new Byn(price.getKopecks() * number);
    }

    protected String fieldsToString() {
        return "";
    }

    @Override
    public String toString() {
        return name + ";" + price + ";" + number + fieldsToString() + ";" + getCost();
    }


    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Purchase))
            return false;
        Purchase other = (Purchase) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (price == null){
            if (other.name != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        return true;
    }

}
