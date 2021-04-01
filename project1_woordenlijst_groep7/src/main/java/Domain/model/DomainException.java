package Domain.model;

public class DomainException extends RuntimeException {

    public DomainException(String message, Exception e){
        super(message,e);

    }

    public DomainException(){

    }
}

