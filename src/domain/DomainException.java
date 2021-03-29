package domain;

public class DomainException extends RuntimeException {

    public DomainException(String message){
        System.out.println(message);
    }

    public DomainException(){

    }
}
