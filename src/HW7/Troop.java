package HW7;

/**
 * Defines troops in the army.
 *
 * @author Alex Zhang
 * @version 1.0
 */
public abstract class Troop {
    private String name;
    private int experienceLevel;
    private int health;

    /**
     * Creates a Troop with given name, experience level, and health.
     *
     * @param name            Name of the troop .
     * @param experienceLevel Experience level of the troop. Will be set between 1 and 50.
     * @param health          Health of the troop. Will be set between 1 and 100.
     */
    public Troop(String name, int experienceLevel, int health) {
        this.name = name;
        this.setExperienceLevel(experienceLevel);
        this.setHealth(health);
    }

    /**
     * Gets Troop name.
     *
     * @return Name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the troop.
     *
     * @param name Name of the troop.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the experience level of the troop.
     *
     * @return Experience level of the troop.
     */
    public int getExperienceLevel() {
        return experienceLevel;
    }

    /**
     * Sets the experience level of the troop. Will be limited between 1 and 50.
     *
     * @param experienceLevel Desired experience level of the troop.
     */
    public void setExperienceLevel(int experienceLevel) {
        if (experienceLevel < 1) {
            this.experienceLevel = 1;
        } else if (experienceLevel > 50) {
            this.experienceLevel = 50;
        } else {
            this.experienceLevel = experienceLevel;
        }
    }

    /**
     * Gets the health of the troop.
     *
     * @return The health of the troop.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets the health of the troop. Is limited between 1 and 100.
     *
     * @param health Health of the troop.
     */
    public void setHealth(int health) {
        if (health < 1) {
            this.health = 1;
        } else if (health > 100) {
            this.health = 100;
        } else {
            this.health = health;
        }
    }

    /**
     * Trains the troop with another.
     *
     * @param p Other troop to train with.
     */
    public abstract void trainWith(Troop p);

    /**
     * Represents the troop as a string.
     *
     * @return String representation.
     */
    @Override
    public String toString() {
        return String.format("My name is %s, my experience level is %d, and my health is %d",
                this.name, this.experienceLevel, this.health);
    }


    /**
     * Checks for equality with another troop.
     *
     * @param o Troop to be compared with.
     * @return True if equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Troop)) {
            return false;
        }
        Troop troop = (Troop) o;
        return experienceLevel == troop.experienceLevel && health == troop.health && this.name.equals(troop.name);
    }
}
