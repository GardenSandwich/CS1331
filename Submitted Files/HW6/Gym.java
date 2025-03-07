import java.util.Arrays;

/**
 * Class gym that holds weight machines and free weights.
 *
 * @author Alex Zhang
 * @version 1.0
 */
public class Gym {
    private FreeWeight[] freeWeights;
    private WeightMachine[] weightMachines;

    /**
     * Creates a gym with given arrays of weights and machines. Sorts arrays.
     *
     * @param freeWeights    Weights in the gym
     * @param weightMachines Machines in the gym
     */
    public Gym(FreeWeight[] freeWeights, WeightMachine[] weightMachines) {
        this.freeWeights = freeWeights;
        this.weightMachines = weightMachines;

        Arrays.sort(this.freeWeights);
        Arrays.sort(this.weightMachines);
    }

    /**
     * Creates an empty gym with no weights or machines.
     */
    public Gym() {
        this(new FreeWeight[]{}, new WeightMachine[]{});
    }

    /**
     * Prints the String representation of all the equipment in the gym in order, each in its own line.
     */
    public void browseGymEquipment() {
        for (FreeWeight w : freeWeights) {
            System.out.println(w);
        }
        for (WeightMachine w : weightMachines) {
            System.out.println(w);
        }
    }

    /**
     * Adds a new free weight to the gym.
     *
     * @param w Free weight to be added.
     */
    public void addEquipment(FreeWeight w) {
        FreeWeight[] newFreeWeights = new FreeWeight[this.freeWeights.length + 1];
        System.arraycopy(freeWeights, 0, newFreeWeights, 0, freeWeights.length);
        newFreeWeights[newFreeWeights.length - 1] = w;
        Arrays.sort(newFreeWeights);
        freeWeights = newFreeWeights;
    }

    /**
     * Adds a new machine to the gym.
     *
     * @param m Machine to be added.
     */
    public void addEquipment(WeightMachine m) {
        WeightMachine[] newWeightMachines = new WeightMachine[this.weightMachines.length + 1];
        System.arraycopy(weightMachines, 0, newWeightMachines, 0, weightMachines.length);
        newWeightMachines[newWeightMachines.length - 1] = m;
        Arrays.sort(newWeightMachines);
        weightMachines = newWeightMachines;
    }

    /**
     * Finds the free weight with the given ID.
     *
     * @param target ID to be searched for
     * @return Free weight if found, null if not found.
     */
    public FreeWeight getFreeWeight(String target) {
        for (FreeWeight w : freeWeights) {
            if (target.equals(w.getFreeWeightID())) {
                return w;
            }
        }
        return null;
    }

    /**
     * Finds the machine with the given ID.
     *
     * @param target ID to be searched for
     * @return Machine if found, null if not found.
     */
    public WeightMachine getWeightMachine(String target) {
        for (WeightMachine w : weightMachines) {
            if (target.equals(w.getWeightMachineID())) {
                return w;
            }
        }
        return null;
    }

    /**
     * Gets total amount of machines and weights in the gym.
     *
     * @return Total amount.
     */
    public int getEquipmentCount() {
        return freeWeights.length + weightMachines.length;
    }
}
