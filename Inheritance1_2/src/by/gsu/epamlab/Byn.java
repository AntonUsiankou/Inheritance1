package by.gsu.epamlab;

public final class Byn implements Comparable<Byn> {
    private int kopecks;

    public Byn() {
    }

    public Byn(int kopecks) {
        this.kopecks = kopecks;
    }

    public Byn(Byn byn) {
        this(byn.kopecks);
    }

    public Byn addition(Byn byn) {
        this.kopecks += byn.kopecks;
        return this;
    }

    public Byn subtraction(Byn byn) {
        this.kopecks -= byn.kopecks;
        return this;
    }

    public Byn multiply(int k) {
        this.kopecks *= k;
        return this;
    }

    public Byn multiply(double k, RoundMethod roundMethod, int digits) {
        this.kopecks = roundMethod.rounding(this.kopecks * k, digits);
        return this;
    }

    public Byn round(RoundMethod roundMethod, int digits) {
        kopecks = roundMethod.rounding(this.kopecks, digits);
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
    public int compareTo(Byn byn) {
        return kopecks - byn.kopecks;
    }

}
