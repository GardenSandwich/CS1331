package HW5;

/**
 * Defines Enemy behavior and actions, a subclass of Entity.
 *
 * @author Alex Zhang
 * @version 1.0
 */
public class Enemy extends Entity {
    private final boolean canPierceArmor;


    /**
     * Creates Enemy given name, health, and armor piercing.
     *
     * @param name           Name of the enemy.
     * @param health         Health of the enemy.
     * @param canPierceArmor True if the enemy can piece armor, false otherwise.
     */
    public Enemy(String name, int health, boolean canPierceArmor) {
        super(name, health);
        this.canPierceArmor = canPierceArmor;
    }


    /**
     * Creates an Enemy with name and health, and no armor piercing.
     *
     * @param name   Name of the enemy.
     * @param health Health of the enemy.
     */
    public Enemy(String name, int health) {
        super(name, health);
        this.canPierceArmor = false;
    }


    /**
     * Returns the enemy's ability to pierce armor.
     *
     * @return True if the enemy can pierce armor, false otherwise.
     */
    public boolean canPierceArmor() {
        return canPierceArmor;
    }


    /**
     * Attacks a hero, damaging the hero depending on the enemy's ability to pierce armor.
     *
     * @param hero The hero to damage.
     */
    public void attack(Hero hero) {
        if (hero.isAlive()) {
            if (canPierceArmor() || !hero.hasArmor()) {
                hero.takeDamage(3);
            } else {
                hero.takeDamage(1);
            }
        }
    }

    @Override
    public String toString() {
        if (this.isAlive()) {
            return super.toString() + String.format(". I am an enemy that %s pierce armor",
                    this.canPierceArmor() ? "can" : "cannot");
        } else {
            return super.toString() + ". I was an enemy";
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Entity)) {
            return false;
        } else {
            return super.equals(obj) && this.canPierceArmor() == ((Enemy) obj).canPierceArmor();
        }
    }
}
