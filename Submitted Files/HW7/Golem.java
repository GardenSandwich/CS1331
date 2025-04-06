/**
 * Defines golems, a type of troop.
 *
 * @author Alex Zhang
 * @version 1.0
 */
public class Golem extends Troop {
    private int weight;

    /**
     * Creates a golem with given parameters.
     *
     * @param name            Name of the golem.
     * @param experienceLevel Experience level of the golem.
     * @param health          Health of the golem.
     * @param weight          Weight of the golem.
     */
    public Golem(String name, int experienceLevel, int health, int weight) {
        super(name, experienceLevel, health);
        this.weight = weight;
    }

    /**
     * Creates a golem named Nelly, with 19 experience, 80 health, and weight of 10 tons.
     */
    public Golem() {
        super("Nelly", 19, 80);
        this.weight = 10;
    }

    /**
     * Gets the golem's weight.
     *
     * @return Weight of the golem.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Sets the golem's weight.
     *
     * @param weight Desired weight.
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Trains the golem with another troop.
     *
     * @param o Other troop to train with.
     */
    @Override
    public void trainWith(Troop o) {
        if (this.getHealth() < 15 || this.getHealth() == 100 || this.getExperienceLevel() == 50) {
            return;
        } else if (o instanceof Golem) {
            this.setExperienceLevel(this.getExperienceLevel() + 3);
            o.setExperienceLevel(this.getExperienceLevel() + 3);

            this.setHealth(this.getHealth() - 12);
            o.setHealth(o.getHealth() - 12);
        }
    }

    /**
     * Represents the golem as a string.
     *
     * @return String representation.
     */
    @Override
    public String toString() {
        return super.toString() + String.format(". I am a golem that weighs %d tons", this.weight);
    }

    /**
     * Determines if the golem is equal to another troop.
     *
     * @param o Troop to be compared with.
     * @return True if equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Golem)) {
            return false;
        }
        Golem golem = (Golem) o;
        return super.equals(golem) && weight == golem.weight;
    }
}
