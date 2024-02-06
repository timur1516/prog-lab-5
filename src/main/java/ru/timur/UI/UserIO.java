package ru.timur.UI;

import java.io.*;
import java.util.Scanner;

public class UserIO{
    private Scanner scanner;

    public UserIO(InputStream inputStream){
        setInputStream(inputStream);
    }

    public void setInputStream(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    public String readLine(){
        return scanner.nextLine();
    }
    public boolean hasNextLine(){
        return scanner.hasNextLine();
    }
    public void closeInputStream(){
        scanner.close();
    }

    public void print(Object s){
        System.out.print(s);
    }
    public void printLn(Object s){
        System.out.println(s);
    }
    public void printError(Object s){
        System.err.println(s);
    }
}
