package by.gsu.epamlab;

public class Byn implements Comparable<Byn>{
    private int kopecks;

    public Byn(int kopecks){
        this.kopecks = kopecks;
    }

    public int getKopecks() {
        return kopecks;
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
    public int compareTo(Byn o){
        return  this.kopecks - o.kopecks;
    }

}
