package HW5;

public class TestAssignment {
    public static void main(String[] args) {
        // ----- TrainingGround Tests -----
        // Create an indoors training ground using the 1-arg constructor.
        TrainingGround indoors = new TrainingGround("Local Gym");
        // Create an outdoors training ground using the 3-arg constructor.
        TrainingGround outdoors = new TrainingGround("Outdoor Arena", 1.5, true);

        System.out.println("=== Training Grounds ===");
        System.out.println(indoors);    // Expected: "Indoors Training Ground: Local Gym. It has training multiplier 1.00"
        System.out.println(outdoors);   // Expected: "Outdoors Training Ground: Outdoor Arena. It has training multiplier 1.50"
        System.out.println();

        // ----- Hero (Knight & Archer) Tests -----
        // Create a Knight using the 1-arg constructor (default: 40 health, 2 damage).
        Knight arthur = new Knight("Arthur");
        System.out.println("=== Initial Knight ===");
        System.out.println(arthur);
        // Expected (alive): "I am Arthur, and I have 40 health. I deal 2 damage. I am a knight"
        System.out.println();

        // Create an Archer using the 1-arg constructor (default: 20 health, 4 damage, armor unequipped).
        Archer robin = new Archer("Robin");
        System.out.println("=== Initial Archer ===");
        System.out.println(robin);
        // Expected (alive): "I am Robin, and I have 20 health. I deal 4 damage. I am an archer with my armor unequipped"
        System.out.println();

        // ----- Enemy Tests -----
        // Create an enemy that cannot pierce armor using the 2-arg constructor.
        Enemy goblin = new Enemy("Goblin", 15);
        // Create an enemy that can pierce armor using the 3-arg constructor.
        Enemy orc = new Enemy("Orc", 20, true);

        System.out.println("=== Initial Enemies ===");
        System.out.println(goblin);
        // Expected (alive, cannot pierce): "I am Goblin, and I have 15 health. I am an enemy that cannot pierce armor"
        System.out.println(orc);
        // Expected (alive, can pierce): "I am Orc, and I have 20 health. I am an enemy that can pierce armor"
        System.out.println();

        // ----- Training Effects -----
        // Knight trains on an outdoors training ground.
        // Increase in damage = (int)(5 * trainingMultiplier) = (int)(5 * 1.5) = 7.
        arthur.train(outdoors);
        System.out.println("After training on outdoors, Knight:");
        System.out.println(arthur);
        // Expected Knight damage: 2 + 7 = 9.
        System.out.println();

        // Archer trains on an indoors training ground (should have no effect).
        robin.train(indoors);
        System.out.println("After training on indoors, Archer (should be unchanged):");
        System.out.println(robin);
        // Archer then trains on outdoors; damage increases by (int)(3 * 1.5) = 4.
        robin.train(outdoors);
        System.out.println("After training on outdoors, Archer:");
        System.out.println(robin);
        // Expected Archer damage: 4 + 4 = 8.
        System.out.println();

        // ----- Attack Tests -----
        // Knight attacks Goblin: Goblin loses damage equal to Knight's current damage.
        arthur.attack(goblin);
        System.out.println("After Knight attacks Goblin:");
        System.out.println(goblin);
        // Goblin's health: 15 - 9 = 6.

        // Archer attacks Orc.
        robin.attack(orc);
        System.out.println("After Archer attacks Orc:");
        System.out.println(orc);
        // Orc's health: 20 - 8 = 12.
        System.out.println();

        // ----- Enemy Attack Tests -----
        // Goblin attacks Knight.
        // Since Knight always wears armor and Goblin cannot pierce armor, damage dealt = 1.
        goblin.attack(arthur);
        System.out.println("After Goblin attacks Knight:");
        System.out.println(arthur);
        // Knight's health: 40 - 1 = 39.

        // Orc attacks Archer.
        // Archer is not wearing armor at this point so damage dealt = 3.
        orc.attack(robin);
        System.out.println("After Orc attacks Archer:");
        System.out.println(robin);
        // Archer's health: 20 - 3 = 17.
        System.out.println();

        // ----- Archer Armor Tests -----
        // Archer equips armor.
        robin.equipArmor();
        System.out.println("After Archer equips armor:");
        System.out.println(robin);
        // Expected to show "with my armor equipped" in toString.

        // Archer unequips armor.
        robin.unequipArmor();
        System.out.println("After Archer unequips armor:");
        System.out.println(robin);
        System.out.println();

        // ----- Healing & Damage Boundary Tests -----
        // Heal Archer while alive.
        robin.heal(5);
        System.out.println("After Archer heals 5 points:");
        System.out.println(robin);
        // Archer's health should increase if still alive.
        System.out.println();

        // Test fatal damage on Knight.
        arthur.takeDamage(100);  // This should set Arthur's health to 0.
        System.out.println("After Knight takes 100 damage (should be dead):");
        System.out.println(arthur);
        // Attempt to heal dead Knight (should have no effect).
        arthur.heal(10);
        System.out.println("After attempting to heal dead Knight:");
        System.out.println(arthur);
        System.out.println();

        // Test enemy health boundary.
        goblin.takeDamage(20);  // Goblin health goes from 6 to 0.
        System.out.println("After Goblin takes extra damage (should be dead):");
        System.out.println(goblin);
        goblin.heal(10);  // Should not heal because goblin is dead.
        System.out.println("After attempting to heal dead Goblin:");
        System.out.println(goblin);
        System.out.println();

        // ----- Equals Method Tests -----
        // Create another Knight with the default values.
        Knight anotherArthur = new Knight("Arthur");
        System.out.println("Testing equals method for Knight:");
        System.out.println("arthur.equals(anotherArthur): " + arthur.equals(anotherArthur));

        // Create a new Archer that matches the original default Archer.
        Archer robinClone = new Archer("Robin", 20, 4, false);
        System.out.println("Testing equals method for Archer:");
        System.out.println("robin.equals(robinClone): " + robin.equals(robinClone));

        // Create a new Enemy matching Goblin's initial properties.
        Enemy goblin2 = new Enemy("Goblin", 15);
        System.out.println("Testing equals method for Enemy:");
        System.out.println("goblin.equals(goblin2): " + goblin.equals(goblin2));
    }
}

