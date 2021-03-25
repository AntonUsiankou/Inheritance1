package by.gsu.epamlab;

public class Byn implements Comparable<Byn>{
    int kopecks;

    public Byn(int kopecks){
        this.kopecks = kopecks;
    }

    public Byn(Byn byn) {
        this(byn.kopecks);
    }

    public Byn(int rubs, int coins){
        this(rubs * 100 + coins);
    }

    public Byn() {
    }

    @Override
    public String toString() {
        return kopecks / 100 + "." + kopecks % 100 / 10 + kopecks % 10;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Byn)) return false;
        Byn byn = (Byn) obj;
        return kopecks == byn.kopecks;
    }

    @Override
    public int compareTo(Byn byn){
        return kopecks - byn.kopecks;
    }

    public int getRubs(){
        return this.kopecks / 100;
    }
    public int getCoins(){
        return this.kopecks % 100;
    }

    public Byn add(Byn byn) {
        kopecks += byn.kopecks;
        return this;
    }

    public Byn sub(Byn byn) {
        kopecks -= byn.kopecks;
        return this;
    }

    public Byn mul(int k) {
        kopecks *= k;
        return this;
    }

    public Byn mul(double k, Round round, int digits){
        this.kopecks = round.rounding(this.kopecks * k, digits);
        return this;
    }

    public Byn mul(double k, int digits){
        mul(k, Round.ROUND, digits);
        return this;
    }

    public Byn mul(double k) {
        mul(k, Round.ROUND, 0);
        return this;
    }

    public Byn mul (double k, Round round){
        mul(k, round, 0);
        return this;
    }

    public Byn round (Round round){
        round(round, 0);
        return this;
    }

    public Byn round(int digits) {
        round(Round.ROUND, digits);
        return this;
    }

    public Byn round(Round round, int digits){
        this.kopecks = round.rounding(this.kopecks, digits);
        return this;
    }

/*
    public Byn mul(double x) {
        kopecks = (int) Math.round(kopecks * x);
        return this;
    }
*/
    public static enum Round {
        CEIL{
            double roundFunction(double roundingValue){
                return Math.ceil(roundingValue);
            }
        },
        ROUND{
            double roundFunction(double roundingValue){
                return Math.round(roundingValue);
            }
        },
        FLOOR{
            double roundFunction(double roundingValue){
                return Math.floor(roundingValue);
            }
        };

        abstract double roundFunction(double roundingValue);

        private int[] tenPowD = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};

        private int rounding(double roundingValue, int digits) {
            return (int) roundFunction(roundingValue / tenPowD[digits]) * tenPowD[digits];
        }
    }
}
