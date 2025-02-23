package HW5;

/**
 * Defines attributes of a knight. A subclass of Hero.
 */
public class Knight extends Hero{

    /** Creates Knight with name, health, and damage.
     *
     * @param name Desired name of the knight.
     * @param Health Desired health of the knight. Will be set to zero if the value goes negative.
     * @param Damage The amount of health the knight gives.
     */
    public Knight(String name, int Health, int Damage) {
        super(name, Health, Damage);
    }

    private Knight(String name, int health) {
        super(name, health, 2);
    }

    public Knight(String name) {
        super(name, 40, 2);
    }

    @Override
    public void train(TrainingGround ground) {
        this.increaseDamage((int)(ground.getTrainingMultiplier() * 5));
    }

    @Override
    public boolean hasArmor() {
        return true;
    }

    @Override
    public String toString() {
        if(this.isAlive()){
            return super.toString() + ". I am a knight";
        } else {
            return super.toString() + ". I was a knight";
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (! (obj instanceof Knight)) {
            return false;
        } else {
            return super.equals(obj);
        }
    }
}
