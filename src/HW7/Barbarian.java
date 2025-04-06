package HW7;

/**
 * Defines barbarians, a type of troop that is treatable.
 *
 * @author Alex Zhang
 * @version 1.0
 */
public class Barbarian extends Troop implements Treatable {
    private final boolean isElite;

    /**
     * Creates a barbarian with given attributes.
     *
     * @param name            Name of the barbarian.
     * @param experienceLevel Experience level of the barbarian. Limited between 1 and 50.
     * @param health          Health of the barbarian. Limited between 1 and 100.
     * @param isElite         Whether the barbarian is elite.
     */
    public Barbarian(String name, int experienceLevel, int health, boolean isElite) {
        super(name, experienceLevel, health);
        this.isElite = isElite;
    }

    /**
     * Creates barbarian Buzz, with 1 experience and 25 health.
     *
     * @param isElite Whether Buzz should be elite.
     */
    public Barbarian(boolean isElite) {
        super("Buzz", 1, 25);
        this.isElite = isElite;
    }

    /**
     * Returns if the barbarian is elite.
     *
     * @return Whether the barbarian is elite.
     */
    public boolean isElite() {
        return this.isElite;
    }

    /**
     * Trains this barbarian with another troop.
     *
     * @param o Other troop to train with.
     */
    @Override
    public void trainWith(Troop o) {
        if (this.getHealth() < 10 || this.getHealth() == 100 || this.getExperienceLevel() == 50) {
            return;
        } else if (o instanceof Barbarian) {
            int oldHealth = this.getHealth();
            this.setHealth((int) (this.getHealth() - 0.1 * o.getExperienceLevel()));
            o.setHealth((int) (o.getHealth() - 0.1 * o.getExperienceLevel()));
            System.out.printf("AAAARGH! I just trained with a level %d barbarian, and my health went from %d to %d\n",
                    o.getExperienceLevel(), oldHealth, this.getHealth());
            if (!(this.isElite && ((Barbarian) o).isElite)) {
                this.setExperienceLevel(this.getExperienceLevel() + 5);
                o.setExperienceLevel(o.getExperienceLevel() + 5);
            } else {
                this.setExperienceLevel(this.getExperienceLevel() + 8);
                o.setExperienceLevel(o.getExperienceLevel() + 8);
            }
        } else if (o instanceof Archer) {
            if (((Archer) o).getHairColor().equals("purple")) {
                int oldHealth = this.getHealth();
                this.setHealth(this.getHealth() + 10);
                System.out.printf("YAAARG. My health increased from %d to %d\n", oldHealth, this.getHealth());
                this.setExperienceLevel(this.getExperienceLevel() + 1);
                o.setExperienceLevel(o.getExperienceLevel() + 1);
            } else {
                this.setExperienceLevel(this.getExperienceLevel() - 15);
                System.out.println("AAAARGH! I hate that color!");
            }
        }
    }

    /**
     * Treats the barbarian by adding 5 to the health.
     */
    @Override
    public void treat() {
        this.setHealth(this.getHealth() + 5);
    }

    /**
     * Returns if the barbarian needs treatment. The barbarian needs treatment if its health is less than 100.
     *
     * @return If the health of the barbarian is less than 100.
     */
    @Override
    public boolean needsTreatment() {
        return !(this.getHealth() == 100);
    }

    /**
     * Makes the barbarian scream.
     */
    public void scream() {
        System.out.println("AAAARGH!");
    }

    /**
     * Represents the barbarian as a String.
     *
     * @return String representation.
     */
    @Override
    public String toString() {
        String eliteStatus = this.isElite ? "an elite" : "a regular";

        return super.toString() + String.format(". I am %s barbarian", eliteStatus);
    }

    /**
     * Returns if the barbarian is equal to another troop.
     *
     * @param o Troop to be compared with.
     * @return True if the barbarian is equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Barbarian)) {
            return false;
        }
        Barbarian barbarian = (Barbarian) o;
        return super.equals(o) && this.isElite == barbarian.isElite;
    }
}
