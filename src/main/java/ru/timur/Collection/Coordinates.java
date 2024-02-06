package ru.timur.Collection;

/**
 * Class to store and operate with coordinates
 *
 * @author Timur Stupin
 */
public class Coordinates {
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
        return "Coordinates{" +
                "\nx=" + x +
                ",\ny=" + y +
                "\n}";
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
