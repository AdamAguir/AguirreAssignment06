/**
 * @author: Adam Aguirre
 * Assignment 06
 * 3/2/21
 */
public class InsufficientFundsException extends RuntimeException{

    public InsufficientFundsException(){
        super();
    }

    public InsufficientFundsException(String error){
        super(error);
    }
}