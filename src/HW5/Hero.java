package HW5;

/**
 * Class Hero that is a subclass of Entity.
 *
 * @author Alex Zhang
 * @version 1.0
 */
public abstract class Hero extends Entity {
    private int damage;

    /**
     * Creates a Hero given name, health, and damage.
     *
     * @param name Name of Hero.
     * @param health Health of Hero.
     * @param damage Damage the Hero gives out.
     */
    public Hero(String name, int health, int damage) {
        super(name, health);
        this.damage = Math.max(0, damage);
    }


    /**
     * Creates a Hero given name and health. Sets damage to 1.
     *
     * @param name Name of Hero.
     * @param health Health of Hero.
     */
    public Hero(String name, int health) {
        super(name, health);
        this.damage = 1;
    }

    /**
     * Gets the damage the hero gives out.
     *
     * @return damage given out by hero.
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Increases damage the hero gives out. Protected.
     *
     * @param modifier Amount to increase the hero's given damage by.
     */
    protected void increaseDamage(int modifier) {
        if (this.isAlive()) {
            this.damage = Math.max(this.damage + modifier, 0);
        }
    }

    /**
     * Increases the damage the hero gives out based on the training ground.
     *
     * @param ground Training ground for the hero to use.
     */
    public abstract void train(TrainingGround ground);

    /**
     * Returns whether the Hero has armor.
     *
     * @return True if the hero has armor, false otherwise.
     */
    public abstract boolean hasArmor();

    /**
     * Attacks an enemy by decreasing the enemy's health.
     *
     * @param enemy Enemy to give damage to.
     */
    public void attack(Enemy enemy) {
        if(this.isAlive()) {
            enemy.takeDamage(this.getDamage());
        }
    }

    @Override
    public String toString() {
        if (this.isAlive()) {
            return super.toString() + String.format(". I deal %d damage", this.getDamage());
        } else {
            return super.toString();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Hero)) {
            return false;
        } else {
            return super.equals(obj) && ((Hero) obj).getDamage() == this.getDamage();
        }
    }
}
