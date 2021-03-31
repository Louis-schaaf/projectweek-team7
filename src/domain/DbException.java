package domain;

public class DbException extends RuntimeException {
    public DbException(String message, Exception e){
        super(message,e);

    }

    public DbException(){

    }
}
