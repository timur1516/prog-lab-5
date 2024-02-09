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

    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Integer getSalary() {
        return this.salary;
    }
    public LocalDateTime getEndDate(){
        return this.endDate;
    }

    @Override
    public int compareTo(Worker o) {
        return (int) (this.id - o.getId());
    }

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
    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public Status getStatus() {
        return status;
    }

    public Person getPerson() {
        return person;
    }
}

