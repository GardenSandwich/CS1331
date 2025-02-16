package HW4;

public class Habitat {
    private String name;
    private Animal[] animals;
    private int animalCount;

    public Habitat(String name, int capacity) {
        this.name = name;
        animals = new Animal[capacity];
    }

    public boolean isFull() {
        return animalCount == animals.length;
    }

    public int getCapacity() {
        return animals.length;
    }

    public boolean addAnimal(Animal a) {
        if (this.isFull() || this.isInHabitat(a)) {
            return false;
        } else {
            animals[animalCount] = a;
            animalCount++;
            return true;
        }
    }

    public boolean removeAnimal(Animal a) {
        if (!this.isInHabitat(a)) {
            return false;
        } else {
            for (int i = 0; i < animals.length; i++) {
                if (animals[i] == a) {
                    animals[i] = null;
                    animalCount--;
                    this.animals = shiftAnimalsToLeft(this.animals, i);
                    return true;
                }
            }
        }
        return false;
    }

    public void feedAnimals(int amount) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i] != null) {
                animals[i].eat(amount);
            }
        }
    }

    public Animal[] getAllAnimals() {
        Animal[] output = new Animal[animalCount];
        int index = 0;

        for (int i = 0; i < animalCount; i++) {
            if (animals[i] != null) {
                output[index] = animals[i];
                index++;
            }
        }
        return output;
    }

    public Animal[] getHungryAnimals() {
        int hungryCount = 0;
        for (Animal a : animals) {
            if (a.isHungry()) {
                hungryCount++;
            }
        }

        Animal[] output = new Animal[hungryCount];
        int index = 0;
        for (int i = 0; i < animalCount; i++) {
            if (animals[i] != null && animals[i].isHungry()) {
                output[index] = animals[i];
                index++;
            }
        }

        return output;
    }

    public String toString() {
        String plurality = this.animalCount == 1 ? "" : "s";
        return String.format("%s has %d animal%s and has a capacity of %d",
                this.name, this.animalCount, plurality, this.animals.length);
    }

    private boolean isInHabitat(Animal a) {
        for (int i = 0; i < animalCount; i++) {
            if (a == animals[i]) {
                return true;
            }
        }
        return false;
    }

    private static Animal[] shiftAnimalsToLeft(Animal[] animals, int position) {
        Animal[] output = animals;
        if (position >= 0) System.arraycopy(animals, 0, output, 0, position);
        if (animals.length - 1 - position >= 0)
            System.arraycopy(animals, position + 1, output, position, animals.length - 1 - position);
        return output;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAnimalCount() {
        return animalCount;
    }
}
