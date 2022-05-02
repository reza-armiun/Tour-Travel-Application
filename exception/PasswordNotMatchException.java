package razarm.tosan.exception;

import javax.naming.directory.InvalidAttributeValueException;

public class PasswordNotMatchException extends InvalidAttributeValueException {


    public PasswordNotMatchException(String explanation) {
        super(explanation);
    }
}
