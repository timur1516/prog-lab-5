package ru.timur.Controllers;

import ru.timur.Collection.Worker;
import ru.timur.Constants;
import ru.timur.Exceptions.FieldInputException;
import ru.timur.Exceptions.InvalidDataException;
import ru.timur.Validators.WorkerValidators;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Class which completes all operations with Collection of workers
 *
 * @author Timur Stupin
 */
public class CollectionController {
    /**
     * Collection of workers, which we operate on
     */
    private PriorityQueue<Worker> collection;
    /**
     * Collection's creation date
     * In fact it is equal to CollectionManager object creation date
     */
    private final LocalDateTime creationDate;

    public CollectionController(PriorityQueue<Worker> collection) {
        this.collection = collection;
        this.creationDate = LocalDateTime.now();
    }

    /**
     * Method to check if collection contains valid values
     * Used to validate input collection from data file
     * Firstly it checks if all id are unique
     * Then it validate all fields using WorkerValidator
     * @return
     */
    public static boolean isValid(PriorityQueue<Worker> collection){
        Set<Long> idSet = collection.stream().map(Worker::getId).collect(Collectors.toSet());
        if(idSet.size() != collection.size()) return false;
        for(Worker worker : collection){
            try {
                WorkerValidators.idValidator.validate(String.valueOf(worker.getId()));
                WorkerValidators.nameValidator.validate(String.valueOf(worker.getName()));
                WorkerValidators.xValidator.validate(String.valueOf(worker.getCoordinates().getX()));
                WorkerValidators.yValidator.validate(String.valueOf(worker.getCoordinates().getY()));
                WorkerValidators.salaryValidator.validate(String.valueOf(worker.getSalary()));
                WorkerValidators.statusValidator.validate(String.valueOf(worker.getStatus()));
                WorkerValidators.heightValidator.validate(String.valueOf(worker.getPerson().getHeight()));
                WorkerValidators.eyeColorValidator.validate(String.valueOf(worker.getPerson().getEyeColor()));
                WorkerValidators.nationalityValidator.validate(String.valueOf(worker.getPerson().getNationality()));
            } catch (FieldInputException e){
                return false;
            }
        }
        return true;
    }

    public long generateId(){
        if(this.collection.isEmpty()) return 1;
        return this.collection
                .stream()
                .map(Worker::getId)
                .max(Long::compareTo).get() + 1;
    }

    /**
     * Method to get the collection
     *
     * @return Collection of workers
     */
    public PriorityQueue<Worker> getCollection() {
        return this.collection;
    }

    /**
     * Method to get the creation date of the class object
     *
     * @return The creation date of the collection
     */
    public LocalDateTime getCreationDate(){
        return this.creationDate;
    }

    /**
     * This method chech if collection contain any element with id equal to given
     * @param id to compare with
     * @return true if element was found, else false
     */
    public boolean containsId(long id){
        if(this.collection.isEmpty()) return false;
        return this.collection.stream().anyMatch(worker -> worker.getId() == id);
    }

    public String getInfo() {
        return "Type: " + this.collection.getClass().getName() +
            "\nCreation date: " + this.creationDate.format(Constants.formatter) +
            "\nSize: " + this.collection.size();
    }

    /**
     * Add new object to collection
     *
     * @param newWorker Object to add
     */
    public void add(Worker newWorker){
        this.collection.add(newWorker);
    }

    /**
     * Updates value of collection element by it's id
     *
     * @param id Element's id
     * @param newWorker New value for the element
     */
    public void update(long id, Worker newWorker){
        removeById(id);
        newWorker.setId(id);
        add(newWorker);
    }

    /**
     * Removes element with given id from collection
     *
     * @param id Element's id
     */
    public void removeById(long id){
        this.collection.removeIf(worker -> worker.getId() == id);
    }

    /**
     * Clear collection
     */
    public void clear(){
        this.collection.clear();
    }

    /**
     * Removes the first element in the collection
     */
    public void removeFirst(){
        this.collection.poll();
    }

    /**
     * Removes all elements which are greater that given
     *
     * @param worker Element to compare with
     */
    public void removeGreater(Worker worker){
        this.collection.removeIf(worker1 -> worker1.compareTo(worker) > 0);
    }

    /**
     * Removes all elements which are lowers than given
     *
     * @param worker Element to compare with
     */
    public void removeLower(Worker worker){
        this.collection.removeIf(worker1 -> worker1.compareTo(worker) < 0);
    }

    /**
     * Method to get worker with minimal salary
     *
     * @return Worker whose salary is minimal
     */
    public Worker getMinBySalary(){
        return this.collection
                .stream()
                .min(Comparator.comparing(Worker::getSalary))
                .orElseThrow(NoSuchElementException::new);
    }

    /**
     * Method to get all workers whose endDate is less that given
     *
     * @param endDate Date to compare with
     * @return List of workers
     */
    public List<Worker> getLessThanEndDate(LocalDateTime endDate){
        return this.collection
                .stream()
                .filter(worker1 -> worker1.getEndDate().isBefore(endDate))
                .toList();
    }

    /**
     * Method to get salaries of all workers in descending order
     *
     * @return List of salaries
     */
    public List<Integer> getDescendingSalaries(){
        return this.collection
                .stream()
                .map(Worker::getSalary)
                .sorted(Comparator.reverseOrder()).toList();
    }
}
