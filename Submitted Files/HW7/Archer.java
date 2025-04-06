/**
 * Defines archers, a type of troop that is treatable.
 *
 * @author Alex Zhang
 * @version 1.0
 */
public class Archer extends Troop implements Treatable {
    private String hairColor;

    /**
     * Creates an archer with given parameters.
     *
     * @param name            Name of the archer.
     * @param experienceLevel Experience level of the archer.
     * @param health          Health of the archer.
     * @param hairColor       Hair color of the archer.
     */
    public Archer(String name, int experienceLevel, int health, String hairColor) {
        super(name, experienceLevel, health);
        this.hairColor = hairColor;
    }

    /**
     * Creates and archer named Sally with 10 experience and 15 health.
     *
     * @param hairColor Sally's hair color.
     */
    public Archer(String hairColor) {
        super("Sally", 10, 15);
        this.hairColor = hairColor;
    }

    /**
     * Gets the archer's hair color.
     *
     * @return Hair color.
     */
    public String getHairColor() {
        return hairColor;
    }

    /**
     * Sets the archer's hair color.
     *
     * @param hairColor Desired color.
     */
    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    /**
     * Trains the archer with another troop.
     *
     * @param o Other troop to train with.
     */
    @Override
    public void trainWith(Troop o) {
        if (this.getHealth() < 5 || this.getHealth() == 100 || this.getExperienceLevel() == 50) {
            return;
        } else if (o instanceof Archer) {
            if (!this.getHairColor().equals(((Archer) o).getHairColor())) {
                this.setExperienceLevel(this.getExperienceLevel() + 2);
                o.setExperienceLevel(o.getExperienceLevel() + 2);
                System.out.println("Oof! I prefer training with other archers with the same hair color as me");
            } else {
                this.setExperienceLevel(this.getExperienceLevel() + 4);
                o.setExperienceLevel(o.getExperienceLevel() + 4);
                System.out.println("I like training with other archers with the same hair color as me");
            }

            this.setHealth(this.getHealth() - 5);
            o.setHealth(o.getHealth() - 5);
        } else if (o instanceof Barbarian) {
            this.setHealth(this.getHealth() - 10);
            System.out.printf("Gross. Go away %s! I hate training with Barbarians!", o.getName());
        }
    }

    /**
     * Treats the archer by adding 3 health.
     */
    @Override
    public void treat() {
        this.setHealth(this.getHealth() + 3);
    }

    /**
     * Returns if the archer needs treatment.
     *
     * @return True if health is less than 80, false otherwise.
     */
    @Override
    public boolean needsTreatment() {
        return this.getHealth() < 80;
    }

    /**
     * Represents the archer as a string.
     *
     * @return String representation.
     */
    @Override
    public String toString() {
        return super.toString() + String.format(". I am an archer with %s hair", this.hairColor);
    }


    /**
     * Determines if the archer is equal to another troop.
     *
     * @param o Troop to be compared with.
     * @return True if equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Archer)) {
            return false;
        }
        Archer archer = (Archer) o;
        return super.equals(o) && this.hairColor.equals(archer.getHairColor());
    }
}
