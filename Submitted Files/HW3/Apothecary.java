import java.util.Scanner;
import java.util.Locale;
import java.text.NumberFormat;

//I worked on the homework assignment alone, using only course materials.
public class Apothecary {
    public static void main(String[] args) {
        //set up scanner and formatter
        Scanner sc = new Scanner(System.in);
        NumberFormat currencyFmt = NumberFormat.getCurrencyInstance(Locale.US);

        //ask for name and then format it
        System.out.print("Welcome to my apothecary! Please enter your name here: ");
        String name = sc.nextLine();
        String formattedName = name.isEmpty() ? formattedName = "Apprentice" : name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();

        //ask for potion type
        System.out.printf("\nHello %s, which potion do you want me to brew? ", formattedName);
        String potionType = sc.nextLine().toLowerCase();

        //set names and ingredient list
        String potionName;
        String potionIngredients;

        switch (potionType) {
            case "potion of clarity":
                potionName = "Potion of Clarity";
                potionIngredients = "2 Vials of Crystal Dew";
                break;
            case "elixir of agility":
                potionName = "Elixir of Agility";
                potionIngredients = "3 Swift Feathers";
                break;
            case "healing draught":
                potionName = "Healing Draught";
                potionIngredients = "1 Phoenix Feather and 2 Vials of Moonlit Dew";
                break;
            case "elixir of elemental power":
                potionName = "Elixir of Elemental Power";
                potionIngredients = "1 Vial of Moonlit Dew, 3 Lava Stones, and 2 Phoenix Feathers";
                break;
            case "death poison":
                //print and exit program
                System.out.println("GUARDS!");
                return;
            default:
                //print and exit program
                System.out.println("I am sorry, I cannot brew that potion.");
                return;
        }

        System.out.printf("The %s requires %s. How many would you like? ", potionName, potionIngredients);
        String providedNumber = sc.next();
        sc.nextLine();
        int potionNumber;

        try {
            potionNumber = Integer.parseInt(providedNumber.trim());
            if (potionNumber < 1) {
                potionNumber = 1; // Default to brewing one potion
            }
        } catch (NumberFormatException e) {
            potionNumber = 1; // Default to brewing one potion
        }


        //declare fees
        int totalCost = 0;

        //hardcode ingredient costs
        int crystalCost = 10;
        int swiftCost = 20;
        int phoenixCost = 50;
        int moonlitCost = 15;
        int stonesCost = 30;

        //temporary variable for number of ingredients
        int numberIngredientsProvided;
        //calculate cost
        switch (potionType) {
            case "potion of clarity":
                totalCost += 10 + (15 * potionNumber);
                System.out.printf("\nHow many %s will you provide? ", "Vials of Crystal Dew");
                numberIngredientsProvided = sc.nextInt();
                totalCost += (numberIngredientsProvided < (2 * potionNumber) ? (2 * potionNumber - numberIngredientsProvided) * crystalCost : 0);
                break;
            case "elixir of agility":
                totalCost += 10 + (15 * potionNumber);
                System.out.printf("\nHow many %s will you provide? ", "Swift Feathers");
                numberIngredientsProvided = sc.nextInt();
                totalCost += (numberIngredientsProvided < (3 * potionNumber) ? (3 * potionNumber - numberIngredientsProvided) * swiftCost : 0);
                break;
            case "healing draught":
                totalCost += 20 + (25 * potionNumber);
                System.out.printf("\nHow many %s will you provide? ", "Phoenix Feathers");
                numberIngredientsProvided = sc.nextInt();
                totalCost += (numberIngredientsProvided < (1 * potionNumber) ? (1 * potionNumber - numberIngredientsProvided) * phoenixCost : 0);
                System.out.printf("How many %s will you provide? ", "Vials of Moonlit Dew");
                numberIngredientsProvided = sc.nextInt();
                totalCost += (numberIngredientsProvided < (2 * potionNumber) ? (2 * potionNumber - numberIngredientsProvided) * moonlitCost : 0);
                break;
            case "elixir of elemental power":
                totalCost += 20 + (25 * potionNumber);
                System.out.printf("\nHow many %s will you provide? ", "Vials of Moonlit Dew");
                numberIngredientsProvided = sc.nextInt();
                totalCost += (numberIngredientsProvided < (1 * potionNumber) ? (1 * potionNumber - numberIngredientsProvided) * moonlitCost : 0);
                System.out.printf("How many %s will you provide? ", "Lava Stones");
                numberIngredientsProvided = sc.nextInt();
                totalCost += (numberIngredientsProvided < (3 * potionNumber) ? (3 * potionNumber - numberIngredientsProvided) * stonesCost : 0);
                System.out.printf("How many %s will you provide? ", "Phoenix Feathers");
                numberIngredientsProvided = sc.nextInt();
                totalCost += (numberIngredientsProvided < (2 * potionNumber) ? (2 * potionNumber - numberIngredientsProvided) * phoenixCost : 0);
                break;
        }
        double finalCost = (double) totalCost;
        sc.nextLine();
        System.out.print("\nIs there anything I should know? ");

        String note = sc.nextLine();

        if (note.equals("The order is for the King")) {
            finalCost *= 0.5;
        }

        System.out.println();

        if (potionNumber > 1) {
            switch (potionType) {
                case "potion of clarity":
                    potionName = "Potions of Clarity";
                    System.out.println(formattedName + ", thank you for requesting the " + potionName + ". The cost is " + currencyFmt.format(finalCost) + ".");
                    break;
                case "elixir of agility":
                    potionName = "Elixirs of Agility";
                    System.out.println(formattedName + ", thank you for requesting the " + potionName + ". The cost is " + currencyFmt.format(finalCost) + ".");
                    break;
                case "healing draught":
                    potionName = "Healing Draughts";
                    System.out.println(formattedName + ", thank you for requesting the " + potionName + ". The cost is " + currencyFmt.format(finalCost) + ".");
                    break;
                case "elixir of elemental power":
                    potionName = "Elixirs of Elemental Power";
                    System.out.println(formattedName + ", thank you for requesting the " + potionName + ". The cost is " + currencyFmt.format(finalCost) + ".");
                    break;
            }
        } else {
            switch (potionType) {
                case "potion of clarity":
                    potionName = "Potion of Clarity";
                    System.out.println(formattedName + ", thank you for requesting the " + potionName + ". The cost is " + currencyFmt.format(finalCost) + ".");
                    break;
                case "elixir of agility":
                    potionName = "Elixir of Agility";
                    System.out.println(formattedName + ", thank you for requesting the " + potionName + ". The cost is " + currencyFmt.format(finalCost) + ".");
                    break;
                case "healing draught":
                    potionName = "Healing Draught";
                    System.out.println(formattedName + ", thank you for requesting the " + potionName + ". The cost is " + currencyFmt.format(finalCost) + ".");
                    break;
                case "elixir of elemental power":
                    potionName = "Elixir of Elemental Power";
                    System.out.println(formattedName + ", thank you for requesting the " + potionName + ". The cost is " + currencyFmt.format(finalCost) + ".");
                    break;
            }
        }
    }
}
