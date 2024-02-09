package ru.timur.UI;

import java.io.*;
import java.util.Scanner;

public class Console {
    private static Console CONSOLE;
    private Scanner scanner;
    private Console(){}
    public static Console getInstance(){
        if(CONSOLE == null){
            CONSOLE = new Console();
        }
        return CONSOLE;
    }
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
    public Scanner getScanner() {
        return scanner;
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
