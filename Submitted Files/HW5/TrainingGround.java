/**
 * Defines behavior and attributes of training grounds.
 *
 * @author Alex Zhang
 * @version 1.0
 */
public class TrainingGround {
    private String name;
    private double trainingMultiplier;
    private boolean isOutdoors;

    /**
     * Creates a training ground given name, multiplier, and location.
     *
     * @param name Name of training ground.
     * @param trainingMultiplier Multiplier of training ground.
     * @param isOutdoors If the training ground is indoors or outdoors.
     */
    public TrainingGround(String name, double trainingMultiplier, boolean isOutdoors) {
        this.name = name;
        this.trainingMultiplier = Math.max(trainingMultiplier, 0);
        this.isOutdoors = isOutdoors;
    }

    /**
     * Creates an indoor training ground with a multiplier of 1, given the name.
     *
     * @param name Name of training ground.
     */
    public TrainingGround(String name) {
        this.name = name;
        this.trainingMultiplier = 1.0;
        this.isOutdoors = false;
    }


    /**
     * Returns the name of the training ground.
     *
     * @return Name of training ground.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the multiplier of the training ground.
     *
     * @return Muliplier of training ground.
     */
    public double getTrainingMultiplier() {
        return trainingMultiplier;
    }

    /**
     * Returns the location of the training ground.
     *
     * @return True if outdoors, false if indoors.
     */
    public boolean isOutdoors() {
        return isOutdoors;
    }

    /**
     * Sets the training multiplier for the training ground.
     *
     * @param trainingMultiplier Multiplier. If lower than zero, the multiplier is set to zero.
     */
    public void setTrainingMultiplier(double trainingMultiplier) {
        this.trainingMultiplier = Math.max(trainingMultiplier, 0);
    }

    @Override
    public String toString() {
        return String.format("%s Training Ground: %s. It has training multiplier %.2f",
                this.isOutdoors() ? "Indoors" : "Outdoors", this.getName(), this.getTrainingMultiplier());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TrainingGround)) {
            return false;
        } else {
            return ((TrainingGround) obj).getName().equals(this.getName())
                    && ((TrainingGround) obj).getTrainingMultiplier() == this.getTrainingMultiplier();
        }
    }
}
