package HW5;

/**
 * This class defines behaviors and attributes of all Entities.
 *
 * @author Alex Zhang
 * @version 1.0
 */
public abstract class Entity {
    private String name;
    private int health;

    /**
     * Creates an entity given name and health.
     *
     * @param name Name of entity.
     * @param health Health of entity.
     */
    public Entity(String name, int health) {
        this.name = name;
        this.setHealth(health);
    }

    /**
     * Gets Entity name.
     *
     * @return Entity name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets Entity Health.
     *
     * @return Entity health.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets entity health.
     *
     * @param health Desired entity health. If health is less than zero, it is set to zero instead.
     */
    private void setHealth(int health) {
        this.health = Math.max(health, 0);
    }


    /**
     * Gets health status of the entity.
     *
     * @return True if health is greater than zero, false othewise.
     */
    public boolean isAlive() {
        return health > 0;
    }

    /**
     * Reduces entity health by given parameter, to a minimum of zero.
     *
     * @param damage amount of damage given to entity.
     */
    public void takeDamage(int damage) {
        this.setHealth(this.getHealth() - damage);
    }

    /**
     * Heals entity by increasing health.
     *
     * @param heal Amount to increase health by.
     */
    public void heal(int heal) {
        if (this.isAlive() && heal > -1) {
            this.setHealth(this.getHealth() + heal);
        }
    }

    @Override
    public String toString() {
        if (this.isAlive()) {
            return String.format("I am %s, and I have %d health", this.getName(), this.getHealth());
        } else {
            return String.format("I was %s", this.getName());
        }

    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Entity)) {
            return false;
        } else {
            return this.getName().equals(((Entity) obj).getName())
                    && this.getHealth() == ((Entity) obj).getHealth();
        }
    }
}
