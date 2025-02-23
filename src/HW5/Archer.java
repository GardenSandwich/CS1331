package HW5;

/**
 * Defines behavior for Archers, a subclass of Hero.
 *
 * @author Alex Zhang
 * @version 1.0
 */
public class Archer extends Hero {
    private boolean hasArmorEquipped;

    /**
     * Constructor using name, health, damage, and armor.
     *
     * @param name             Name of Archer.
     * @param health           Health of archer. Must be more than zero.
     * @param damage           Damage the archer deals.
     * @param hasArmorEquipped If the archer has armor attached.
     */
    public Archer(String name, int health, int damage, boolean hasArmorEquipped) {
        super(name, health, damage);
        this.hasArmorEquipped = hasArmorEquipped;
    }


    /**
     * Partial constructor that takes name and health, setting 4 damage and no armor.
     *
     * @param name   Name of the archer.
     * @param health Health of the archer. Must be more than zero.
     */
    public Archer(String name, int health) {
        super(name, health, 4);
        this.hasArmorEquipped = false;
    }

    /**
     * Creates archer given name, with default 20 health, 4 damage, and no armor.
     *
     * @param name Name of the archer.
     */
    public Archer(String name) {
        super(name, 20, 4);
        this.hasArmorEquipped = false;
    }

    /**
     * Returns if the archer has armor.
     *
     * @return True if the archer has armor, false otherwise.
     */
    public boolean hasArmor() {
        return hasArmorEquipped;
    }

    /**
     * Equips armor to the archer if alive.
     */
    public void equipArmor() {
        if (this.isAlive()) {
            this.hasArmorEquipped = true;
        }
    }

    /**
     * Unequips armor from the archer if alive.
     */
    public void unequipArmor() {
        if (this.isAlive()) {
            this.hasArmorEquipped = false;
        }
    }

    /**
     * Increases damage to the archer.
     *
     * @param ground Training ground for the hero to use.
     */
    @Override
    public void train(TrainingGround ground) {
        if (ground.isOutdoors()) {
            this.increaseDamage((int) (3 * ground.getTrainingMultiplier()));
        }
    }

    @Override
    public String toString() {
        if (this.isAlive()) {
            return super.toString() + String.format(". I am an archer with my armor %s",
                    this.hasArmor() ? "equipped" : "unequipped");
        } else {
            return super.toString() + "I was an archer";
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Archer)) {
            return false;
        } else {
            return super.equals(obj) && this.hasArmorEquipped == ((Archer) obj).hasArmorEquipped;
        }
    }
}
