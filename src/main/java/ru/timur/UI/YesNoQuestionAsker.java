package ru.timur.UI;

import ru.timur.Constants;

public class YesNoQuestionAsker {
    String question;
    public YesNoQuestionAsker(String question){
        this.question = question;
    }
    public boolean ask(){
        if(Constants.SCRIPT_MODE) return true;
        Console.getInstance().printLn(question);
        while (true){
            Console.getInstance().printLn("Please enter yes or no");
            String userAnswer = Console.getInstance().readLine().trim();
            if(userAnswer.equals("yes")){
                return true;
            }
            if(userAnswer.equals("no")){
                return false;
            }
        }
    }
}
