/**
 * Dumbbell class extending Free weight.
 *
 * @author Alex Zhang
 * @version 1.0
 */
public class Dumbbell extends FreeWeight {
    private String gripType;

    /**
     * Constructor for the dumbbell.
     *
     * @param freeWeightID ID of the weight.
     * @param weight       Mass of the weight.
     * @param gripType     Type of grip on the weight.
     */
    public Dumbbell(String freeWeightID, int weight, String gripType) {
        super(freeWeightID, 2, weight);
        this.gripType = gripType;
    }

    /**
     * Gets grip type.
     *
     * @return Grip type.
     */
    public String getGripType() {
        return gripType;
    }

    /**
     * Compares the dumbell to another free weight.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater
     *     than the specified weight.
     */
    @Override
    public int compareTo(FreeWeight o) {
        if (super.compareTo(o) != 0) {
            return super.compareTo(o);
        } else if (!this.gripType.equals(((Dumbbell) o).gripType)) {
            return this.gripType.compareTo(((Dumbbell) o).gripType);
        } else {
            return this.getFreeWeightID().compareTo(o.getFreeWeightID());
        }
    }

    /**
     * Represents the Dumbbell as a string.
     *
     * @return String.
     */
    @Override
    public String toString() {
        return super.toString() + String.format(" dumbbell with %s grip", gripType);
    }
}
