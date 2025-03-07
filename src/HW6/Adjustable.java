package HW6;

/**
 * Interface defining all adjustable weights and machines.
 *
 * @author Alex Zhang
 * @version 1.0
 */
public interface Adjustable {
    /**
     * Adjust by given amount of weight.
     *
     * @param amount Amount to adjust.
     * @return True if successful, false otherwise.
     */
    boolean adjustWeight(int amount);
}
