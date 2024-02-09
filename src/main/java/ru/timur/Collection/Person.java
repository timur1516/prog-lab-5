package ru.timur.Collection;

/**
 * Class to store and work with Person objects
 *
 * @author Timur Stupin
 */
public class Person {
    /**
     * Person's height,
     * Can't be null,
     * Must be greater than zero
     */
    private Long height;

    /**
     * Person's eye color,
     * Can't be null
     */
    private Color eyeColor;

    /**
     * Person's nationality,
     * Can't be null
     */
    private Country nationality;

    public Person(Long height, Color eyeColor, Country nationality) {
        this.height = height;
        this.eyeColor = eyeColor;
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Person:\n" +
                "\theight: " + height + "\n" +
                "\teyeColor: " + eyeColor + "\n" +
                "\tnationality: " + nationality + "\n";
    }

    public Long getHeight() {
        return height;
    }

    public Color getEyeColor() {
        return eyeColor;
    }

    public Country getNationality() {
        return nationality;
    }
}
