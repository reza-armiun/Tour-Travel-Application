package razarm.tosan.exception;

public class InvalidCredentialException extends IllegalArgumentException{

    public InvalidCredentialException() {
    }

    public InvalidCredentialException(String s) {
        super(s);
    }
}
