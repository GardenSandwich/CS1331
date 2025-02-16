package HW4;

import java.util.Scanner;

//I worked on the homework assignment alone, using only course materials
public class Zoo {

    public static void main(String[] args) {
        Habitat[] habitats = new Habitat[Integer.parseInt(args[0])];
        int numOfAnimals = Integer.parseInt(args[1]);

        Scanner sc = new Scanner(System.in);

        //set habitats
        String command;
        String[] commandArgs;

        for (int i = 0; i < habitats.length; i++) {
            command = sc.nextLine();
            commandArgs = command.split(" ");
            habitats[i] = new Habitat(commandArgs[0], Integer.parseInt(commandArgs[1]));
        }

        //set animals
        int currentHabitat = 0;

        for (int i = 0; i < numOfAnimals; i++) {
            command = sc.nextLine();
            commandArgs = command.split(" ");

            //find next non-empty habitat
            while (habitats[currentHabitat].isFull()) {
                if (currentHabitat == habitats.length - 1) {
                    currentHabitat = 0;
                } else {
                    currentHabitat++;
                }
            }
            habitats[currentHabitat].addAnimal(new Animal(commandArgs[0], commandArgs[1],
                    Integer.parseInt(commandArgs[2]), Integer.parseInt(commandArgs[3])));

            if (currentHabitat == habitats.length - 1) {
                currentHabitat = 0;
            } else {
                currentHabitat++;
            }
        }

        System.out.println();

        System.out.println("Habitats and their animals at the beginning of the day:");
        for (Habitat habitat : habitats) {
            System.out.println(habitat.toString());
            for (Animal a : habitat.getAllAnimals()) {
                System.out.println(a.toString());
            }
        }
        System.out.println();

        if (habitats.length > 1) {
            Animal[] firstHabitat = habitats[0].getAllAnimals();
            for (int i = 0; i < firstHabitat.length; i++) {
                if (firstHabitat[i].isHungry()) {
                    habitats[habitats.length - 1].addAnimal(firstHabitat[i]);
                    habitats[0].removeAnimal(firstHabitat[i]);
                    break;
                }
            }
        }

        for (Animal a : habitats[habitats.length - 1].getAllAnimals()) {
            a.eat(10);
        }

        System.out.println("Habitats and their animals at the end of the day:");
        for (Habitat habitat : habitats) {
            System.out.println(habitat.toString());
            for (Animal a : habitat.getAllAnimals()) {
                System.out.println(a.toString());
            }
        }
    }
}
