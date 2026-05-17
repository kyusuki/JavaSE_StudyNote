package Exception.Test5;

public class AgeOutOfBoundsException extends RuntimeException{
    public AgeOutOfBoundsException(){}
    public AgeOutOfBoundsException(String message){
        super(message);
    }
}
