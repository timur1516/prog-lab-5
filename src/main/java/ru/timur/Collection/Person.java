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

    /**
     * Person class constructor
     * @param height height
     * @param eyeColor eye color
     * @param nationality nationality
     */
    public Person(Long height, Color eyeColor, Country nationality) {
        this.height = height;
        this.eyeColor = eyeColor;
        this.nationality = nationality;
    }

    /**
     * Method to get formatted string representation of Person
     * @return String value
     */
    @Override
    public String toString() {
        return "Person:\n" +
                "\theight: " + height + "\n" +
                "\teyeColor: " + eyeColor + "\n" +
                "\tnationality: " + nationality + "\n";
    }

    /**
     * Method to get persons height
     * @return height value
     */
    public Long getHeight() {
        return height;
    }

    /**
     * Method to get persons eye color
     * @return eyeColor value
     */
    public Color getEyeColor() {
        return eyeColor;
    }

    /**
     * Method to get persons nationality
     * @return Nationality value
     */
    public Country getNationality() {
        return nationality;
    }
}
