package HW8;

/**
 * Class defining errors for product transactions.
 *
 * @author Alex Z
 * @version 1.0
 */
public class CannotFulfillTransactionException extends Exception {
    /**
     * Creates a new error defining errors in transaction.
     *
     * @param message Message to be passed.
     */
    public CannotFulfillTransactionException(String message) {
        super(message);
    }
}
