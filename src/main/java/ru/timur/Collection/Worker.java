package ru.timur.Collection;

import ru.timur.Constants;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Objects;

public class Worker implements Comparable<Worker> {
    /**
     * Worker's id,
     * Must be greater than zero,
     * Must be unique,
     * Value is generated automatically
     */
    private long id;

    /**
     * Worker's name,
     * Can't be null,
     * Can't be empty
     */
    private String name;

    /**
     * Worker's coordinates,
     * Can't be null
     */
    private Coordinates coordinates;

    /**
     * Creation date of object,
     * Can't be null,
     * Value is generated automatically
     */
    private java.time.ZonedDateTime creationDate;

    /**
     * Worker's salary,
     * Can't be null,
     * Must be greater than zero
     */
    private Integer salary;

    /**
     * Start day of work,
     * Can't be null
     */
    private java.time.LocalDateTime startDate;

    /**
     * End day of work,
     * Can't be null
     */
    private java.time.LocalDateTime endDate;

    /**
     * Worker's status,
     * Can't be null
     */
    private Status status;

    /**
     * Person of worker,
     * Can't be null
     */
    private Person person;

    public Worker(long id, String name, Coordinates coordinates, ZonedDateTime creationDate, Integer salary, LocalDateTime startDate, LocalDateTime endDate, Status status, Person person) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.salary = salary;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.person = person;
    }

    /**
     * Method to get id
     * @return id
     */
    public long getId() {
        return this.id;
    }

    /**
     * Method to set id
     * @param id new id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Method to get salary
     * @return salary
     */
    public Integer getSalary() {
        return this.salary;
    }

    /**
     * Method to get end date
     * @return end date
     */
    public LocalDateTime getEndDate(){
        return this.endDate;
    }

    /**
     * Method to get name of worker
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to get coordinates of worker
     * @return coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Method to get creation date of worker object
     * @return ZonedDateTime creationDate
     */
    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * Method to get start date of worker
     * @return LocalDateTime workers start day
     */
    public LocalDateTime getStartDate() {
        return startDate;
    }

    /**
     * Method to get status of worker
     * @return Status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Method to get worker Person
     * @return Person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Method to compare to workers
     * Elements are compared by their coordinates (distance from beginning of coordinate system)
     * @param o the object to be compared.
     * @return integer value (0 - equal, <0 - less, >0 - greater)
     */
    @Override
    public int compareTo(Worker o) {
        return this.coordinates.compareTo(o.getCoordinates());
    }

    /**
     * Method to get String version of worker
     * @return Formatted String with structured info about element
     */
    @Override
    public String toString() {
        return "Worker [id = " + id + "]:\n" +
                "\tname: '" + name + "\'\n" +

                "\tcoordinates:\n" +
                (Objects.isNull(coordinates) ? "\t\tnull" :
                "\t\tx: " + coordinates.getX() + "\n" +
                "\t\ty: " + coordinates.getY()) + "\n" +

                "\tcreationDate: " + creationDate.format(Constants.formatter) + "\n" +
                "\tsalary: " + salary + "\n" +
                "\tstartDate: " + startDate.toLocalDate().format(Constants.formatter) + "\n" +
                "\tendDate: " + (!Objects.isNull(endDate) ? endDate.toLocalDate().format(Constants.formatter) : null) + "\n" +
                "\tstatus: " + status + "\n" +

                "\tperson:\n" +
                (Objects.isNull(person) ? "\t\tnull" :
                "\t\theight: " + person.getHeight() + "\n" +
                "\t\teyeColor: " + person.getEyeColor() + "\n" +
                "\t\tnationality: " + person.getNationality());
    }
}

