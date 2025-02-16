package HW4;

public class Animal {
    private final String species;
    private String name;
    private int energy;
    private int health;

    private static int numberOfAnimals = 0;

    public Animal(String species, String name, int energy, int health) {
        this.species = species;
        this.name = name;

        if (energy < 1) {
            this.energy = 1;
        } else if (energy > 100) {
            this.energy = 100;
        } else {
            this.energy = energy;
        }

        if (health < 1) {
            this.health = 1;
        } else if (health > 100) {
            this.health = 100;
        } else {
            this.health = health;
        }

        numberOfAnimals++;
    }

    public Animal(String species, String name) {
        this.species = species;
        this.name = name;
        this.energy = 50;
        this.health = 100;

        numberOfAnimals++;
    }

    public Animal(String name) {
        this("Unknown", name);
    }

    public static int getNumberOfAnimals() {
        return numberOfAnimals;
    }

    public String getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        if (energy < 1) {
            this.energy = 1;
        } else if (energy > 100) {
            this.energy = 100;
        } else {
            this.energy = energy;
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 1) {
            this.health = 1;
        } else if (health > 100) {
            this.health = 100;
        } else {
            this.health = health;
        }
    }

    public void eat(int value) {
        this.setEnergy(this.getEnergy() + 2 * value);
    }

    public void doActivity(int duration, boolean isDangerous) {
        if (isDangerous) {
            this.setEnergy(duration * 8);
        } else {
            this.setEnergy(duration * 5);
        }
    }

    public void goToZooHospital() {
        this.setHealth(100);

        if (this.getEnergy() < 60) {
            this.setEnergy(60);
        }
    }

    public boolean isHungry() {
        return this.getEnergy() < 50;
    }

    public String toString() {
        return String.format("I am %s %s. I have %d energy and %d health",
                this.getSpecies(), this.getName(), this.getEnergy(), this.getHealth());
    }
}
