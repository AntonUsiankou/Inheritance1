package by.gsu.epamlab;

public class Byn implements Comparable<Byn>{
    int kopecks;

    public Byn(int kopecks){
        this.kopecks = kopecks;
    }

    public Byn(Byn byn) {
        this(byn.kopecks);
    }

    public Byn() {

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

    public Byn mul(double x) {
        kopecks = (int) Math.round(kopecks * x);
        return this;
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


}
