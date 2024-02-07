package ru.timur.Collection.Readers;

import ru.timur.Parsers.Parser;
import ru.timur.Validators.Validator;
import ru.timur.Constants;
import ru.timur.Exceptions.InvalidDataException;
import ru.timur.UI.UserIO;

public abstract class ValueReader {
    protected UserIO userIO;
    public ValueReader(UserIO userIO){
        this.userIO = userIO;
    }
    public Object readValue(String valueName, Validator validator, Parser parser) throws InvalidDataException {
        Object value;
        while (true) {
            if(!Constants.SCRIPT_MODE) this.userIO.print("Enter " + valueName + ": ");
            String s = this.userIO.readLine().trim();
            try {
                value = parser.parse(s);
                validator.validate(value);
                break;
            } catch (InvalidDataException e){
                if(Constants.SCRIPT_MODE) throw e;
                else{
                    userIO.printLn(e.getMessage());
                }
            }
        }
        return value;
    }
}
