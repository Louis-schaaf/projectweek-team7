package domain;

public class Punt {
    private int x,y;

    public Punt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Punt) {
            return (((Punt) obj).getX() == this.getX() && ((Punt) obj).getY() == this.getY());
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + this.getX() + ", " + this.getY() + ")";
    }
}
