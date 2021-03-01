public class DepositTooLargeException extends RuntimeException{

    public DepositTooLargeException(){
        super();
    }

    public DepositTooLargeException(String error){
        super(error);
    }
}