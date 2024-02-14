package ru.timur.Collection;

/**
 * Class to store and operate with coordinates
 */
public class Coordinates implements Comparable<Coordinates>{
    /**
     * x coordinate,
     * Max value is 657
     */
    private double x;

    /**
     * y coordinate
     */
    private double y;

    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates:\n" +
                "\tx: " + x + "\n" +
                "\ty: " + y + "\n";
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    @Override
    public int compareTo(Coordinates o) {
        return (int) (((this.x * this.x) + (this.y * this.y)) - ((o.x * o.x) + (o.y * o.y)));
    }
}
