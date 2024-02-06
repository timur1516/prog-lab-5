package ru.timur.Collection.Readers;

import ru.timur.Validators.Validator;
import ru.timur.Constants;
import ru.timur.Exceptions.FieldInputException;
import ru.timur.UI.UserIO;

public abstract class ValueReader {
    protected UserIO userIO;
    public ValueReader(UserIO userIO){
        this.userIO = userIO;
    }
    public String readValue(String valueName, Validator validator) throws FieldInputException {
        String s;
        while (true) {
            if(!Constants.SCRIPT_MODE) this.userIO.print("Enter " + valueName + ": ");
            s = this.userIO.readLine().trim();
            try {
                validator.validate(s);
                break;
            } catch (FieldInputException e){
                if(Constants.SCRIPT_MODE) throw e;
                else{
                    userIO.printLn(e.getMessage());
                }

            }
        }
        return s;
    }
}
