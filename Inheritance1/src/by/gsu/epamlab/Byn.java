package by.gsu.epamlab;

public class Byn implements Comparable<Byn>{
    public int kopecks;

    public Byn(int kopecks){
        this.kopecks = kopecks;
    }

    public Byn(Byn byn) {
        this.kopecks = byn.kopecks;
    }


    public Byn add(Byn byn) {
        return new Byn(kopecks + byn.kopecks);
    }

    public Byn sub(Byn byn) {
        return new Byn(kopecks - byn.kopecks);
    }

    public Byn mul(int k) {
        return new Byn(kopecks * k);
    }
    public Byn mul(double x) {
        return new Byn((int) Math.round(kopecks * x));
    }

    @Override
    public String toString() {
        return kopecks / 100 + "." + kopecks % 100 / 10 + kopecks % 10;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Byn))
            return false;
        Byn other = (Byn) obj;
        if (kopecks != other.kopecks)
            return false;
        return true;
    }

    @Override
    public int compareTo(Byn byn){
        return  this.kopecks - byn.kopecks;
    }


}
