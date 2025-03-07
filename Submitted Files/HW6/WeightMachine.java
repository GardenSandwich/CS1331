/**
 * Class defining weight machines, different from free weights.
 *
 * @author Alex Zhang
 * @version 1.0
 */
public class WeightMachine implements Adjustable, Comparable<WeightMachine> {
    private String weightMachineID;
    private int weightIncrement;
    private int maxWeight;
    private int currentWeight;

    /**
     * Creates a new weight machine with zero current weight.
     *
     * @param weightMachineID ID of the machine.
     * @param weightIncrement Increment the machine can add weight by.
     * @param maxWeight       Maximum possible weight.
     */
    public WeightMachine(String weightMachineID, int weightIncrement, int maxWeight) {
        this.weightMachineID = weightMachineID;
        this.weightIncrement = weightIncrement;
        this.maxWeight = maxWeight;
        currentWeight = 0;
    }

    /**
     * Gets the machine's ID.
     *
     * @return Machine ID.
     */
    public String getWeightMachineID() {
        return weightMachineID;
    }

    /**
     * Gets the increment the machine adds weight by.
     *
     * @return Increment.
     */
    public int getWeightIncrement() {
        return weightIncrement;
    }

    /**
     * Gets them maximum weight the machine can hold.
     *
     * @return Max weight.
     */
    public int getMaxWeight() {
        return maxWeight;
    }

    /**
     * Gets current weight loaded in machine.
     *
     * @return Current weight.
     */
    public int getCurrentWeight() {
        return currentWeight;
    }

    /**
     * Compares the weight machine to other weight machines.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater
     *     than the specified machine.
     */
    @Override
    public int compareTo(WeightMachine o) {
        if (this.maxWeight != o.maxWeight) {
            return this.maxWeight - o.maxWeight;
        } else if (this.currentWeight != o.currentWeight) {
            return o.currentWeight - this.currentWeight;
        } else {
            return this.weightMachineID.compareTo(o.weightMachineID);
        }
    }

    /**
     * Adjusts weight of the machine within limits.
     *
     * @param amount Amount of weight to add to machine.
     * @return True if successful, false if not possible, parameter < 0, or not a multiple of Weight increment.
     */
    @Override
    public boolean adjustWeight(int amount) {
        if (amount < 0 || this.currentWeight + amount > maxWeight || amount % weightIncrement != 0) {
            return false;
        }
        this.currentWeight += amount;
        return true;
    }

    /**
     * Represents the machine as a string.
     *
     * @return String.
     */
    @Override
    public String toString() {
        return String.format("%s: %d lb. weight machine", weightMachineID, currentWeight);
    }
}
