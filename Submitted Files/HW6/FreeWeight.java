//I worked on the homework assignment alone, using only course materials.
/**
 * FreeWeight class defining general free weights.
 *
 * @author Alex Zhang
 * @version 1.0
 */
public abstract class FreeWeight implements Comparable<FreeWeight> {
    private String freeWeightID;
    private int category;
    private int weight;

    /**
     * 3 Parameter constructor for a free weight.
     *
     * @param freeWeightID ID of the weight.
     * @param category     Category of the weight.
     * @param weight       Mass of the weight.
     */
    public FreeWeight(String freeWeightID, int category, int weight) {
        this.freeWeightID = freeWeightID;
        this.category = category;
        this.weight = weight;
    }


    /**
     * Gets weight ID.
     *
     * @return freeWeightID.
     */
    public String getFreeWeightID() {
        return freeWeightID;
    }

    /**
     * Gets mass of weight.
     *
     * @return mass of weight.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Compares a weight to another.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater
     *     than the specified weight.
     */
    @Override
    public int compareTo(FreeWeight o) {
        if (this.category != o.category) {
            return this.category - o.category;
        } else if (this.weight != o.weight) {
            return this.weight - o.weight;
        }
        return 0;
    }


    /**
     * Returns string representation of the weight.
     *
     * @return ID, weight
     */
    public String toString() {
        return String.format("%s: %d lb.", freeWeightID, weight);
    }
}
