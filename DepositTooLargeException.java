/**
 * @author: Adam Aguirre Assignment 06 3/2/21
 */
public class DepositTooLargeException extends RuntimeException {

    public DepositTooLargeException() {
        super();
    }

    public DepositTooLargeException(String error) {
        super(error);
    }
}