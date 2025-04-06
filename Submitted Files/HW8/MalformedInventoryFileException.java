/**
 * Class defining errors when reading or writing to an inventory file.
 *
 * @author Alex Zhang
 * @version 1.0
 */
public class MalformedInventoryFileException extends Exception {
    /**
     * Creates an error when reading inventory files.
     *
     * @param message Message to be passed.
     */
    public MalformedInventoryFileException(String message) {
        super(message);
    }
}
