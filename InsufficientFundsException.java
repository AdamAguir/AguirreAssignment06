public class InsufficientFundsException extends RuntimeException{

    public InsufficientFundsException(){
        super();
    }

    public InsufficientFundsException(String error){
        super(error);
    }
}