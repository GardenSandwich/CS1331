/**
 * Barbell, a subclass of FreeWeight.
 *
 * @author Alex Zhang
 * @version 1.0
 */
public class Barbell extends FreeWeight implements Adjustable {
    private int loadCapacity;
    private int loadedWeight;

    /**
     * Creates a new Barbell.
     *
     * @param freeWeightID ID of the weight
     * @param weight Weight of the barbell
     * @param loadCapacity Total capacity of the weight.
     */
    public Barbell(String freeWeightID, int weight, int loadCapacity) {
        super(freeWeightID, 1, weight);
        this.loadCapacity = loadCapacity;
        this.loadedWeight = 0;
    }

    /**
     * Gets load capacity.
     *
     * @return load capacity.
     */
    public int getLoadCapacity() {
        return loadCapacity;
    }

    /**
     * Gets currently loaded weight.
     *
     * @return current loaded weight.
     */
    public int getLoadedWeight() {
        return loadedWeight;
    }

    /**
     * Compares the barbell to another barbell.
     *
     * @param o the free weight to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater
     *     than the specified weight.
     */
    @Override
    public int compareTo(FreeWeight o) {
        if (super.compareTo(o) != 0) {
            return super.compareTo(o);
        } else if (this.loadCapacity != ((Barbell) o).loadCapacity) {
            return this.loadCapacity - ((Barbell) o).loadCapacity;
        } else if (this.loadedWeight != ((Barbell) o).loadedWeight) {
            return ((Barbell) o).loadedWeight - this.loadedWeight;
        } else {
            return this.getFreeWeightID().compareTo(((Barbell) o).getFreeWeightID());
        }
    }

    /**
     * Adjusts the weight of the dumbell within limits.
     *
     * @param amount Amount to add to the barbell.
     * @return true if successful, false if not possible.
     */
    @Override
    public boolean adjustWeight(int amount) {
        if (amount < 0 || this.loadedWeight + amount > this.loadCapacity) {
            return false;
        }
        this.loadedWeight += amount;
        return true;
    }

    /**
     * Represents the barbell as a string.
     *
     * @return String.
     */
    @Override
    public String toString() {
        return super.toString() + " barbell";
    }
}
