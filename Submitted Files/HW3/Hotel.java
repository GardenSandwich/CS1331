package HW3;

//I worked on the homework assignment alone, using only course materials.
import java.util.Scanner;

public class Hotel {
    public static void main(String[] args) {
        //Declare Scanner
        Scanner sc = new Scanner(System.in);

        //Create 2D arrays based on validated console inputs
        int numOfFloors = Integer.parseInt(args[0]);
        int roomsPerFloor = Integer.parseInt(args[1]);

        if (numOfFloors < 1 || roomsPerFloor < 1) {
            System.out.println("Invalid number of floors or rooms.");
            return;
        }

        String[][] guestNames = createBlankArray(numOfFloors, roomsPerFloor);
        int[][] roomCosts = new int[numOfFloors][roomsPerFloor];
        int[][] daysRemaining = new int[numOfFloors][roomsPerFloor];

        //set al

        //Get and set cost for each floor
        int floorCostNumber = 0;
        int[] floorCostArray;
        do {
            //get input for the floor
            System.out.printf("Costs for floor %d: ", floorCostNumber + 1);
            String[] floorStringArray = sc.nextLine().split(" ");
            floorCostArray = parseStringArrayToInt(floorStringArray, 0);

            //validate
            if (floorCostArray[0] == -1) {
                System.out.println("Room costs must be positive.");
                continue;
            }

            //set values into main 2D array
            System.arraycopy(floorCostArray, 0, roomCosts[floorCostNumber], 0, roomsPerFloor);

            floorCostNumber++;
        } while (floorCostNumber < numOfFloors);

        //start cmd interface
        boolean isRunning = true;
        String currentCommand;
        String[] commandParameters;
        int[] numericalParameters;

        //run cmd
        System.out.println();
        while (isRunning) {
            //take in input and split parameters
            System.out.print("> ");
            currentCommand = sc.nextLine();
            commandParameters = currentCommand.split(" ");

            switch (commandParameters[0]) {
                case "in":
                    //check for already existing guest
                    if (searchRoomNames(guestNames, commandParameters[1])) {
                        System.out.printf("%s already checked in.\n", commandParameters[1]);
                        break;
                    }
                    //check validity of parameters
                    String[] roomNumberParameters = {commandParameters[2], commandParameters[3], commandParameters[4]};
                    numericalParameters = parseStringArrayToInt(roomNumberParameters, 1);

                    if (numericalParameters[0] == -1) {
                        System.out.println("Guests must stay at least one day.");
                        break;
                    }
                    if (numericalParameters[1] > numOfFloors || numericalParameters[2] > roomsPerFloor) {
                        System.out.println("Invalid floor or room.");
                        break;
                    }
                    if (!guestNames[numericalParameters[1] - 1][numericalParameters[2] - 1].equals("")) {
                        System.out.println("Room is already occupied.");
                        break;
                    }

                    //set guest name and stay length
                    guestNames[numericalParameters[1] - 1][numericalParameters[2] - 1] = commandParameters[1];
                    daysRemaining[numericalParameters[1] - 1][numericalParameters[2] - 1] = numericalParameters[0];
                    System.out.printf("Checking in %s to floor %d, room %d, for %d ", commandParameters[1],
                            numericalParameters[1], numericalParameters[2], numericalParameters[0]);
                    System.out.print(numericalParameters[0] > 1 ? "day.\n" : "days.\n");
                    break;
                case "nd":
                    calculatePayment(numOfFloors, roomsPerFloor, guestNames, roomCosts);
                    daysRemaining = decrementDays(daysRemaining);
                    //check out guests
                    for (int i = 0; i < numOfFloors; i++) {
                        for (int j = 0; j < roomsPerFloor; j++) {
                            if (daysRemaining[i][j] == -1) {
                                System.out.printf("Checking out %s from floor %d, room %d.\n", guestNames[i][j],
                                        i + 1, j + 1);
                                daysRemaining[i][j] = 0;
                                guestNames[i][j] = "";
                            }
                        }
                    }
                    break;
                case "price":
                    int[] roomCoordinates = {Integer.parseInt(commandParameters[1]),
                            Integer.parseInt(commandParameters[2])};

                    if (roomCoordinates[0] > numOfFloors || roomCoordinates[1] > roomsPerFloor) {
                        System.out.println("Invalid Floor or Room.");
                        break;
                    }

                    System.out.printf("The price for floor %d, room %d is $%d.00 per day.\n", roomCoordinates[0],
                            roomCoordinates[1], roomCosts[roomCoordinates[0]-1][roomCoordinates[1]-1]);
                    break;
                case "print":
                    for (int i = numOfFloors - 1; i >= 0; i--) {
                        System.out.print("|");
                        for (int j = 0; j < roomsPerFloor; j++) {
                            System.out.print(guestNames[i][j].equals("") ? " |" : guestNames[i][j] + "|");
                        }
                        System.out.print("\n");
                    }
                    break;
                case "quit":
                    isRunning = false;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + currentCommand);
            }
        }
    }

    public static String[][] createBlankArray(int floors, int rooms) {
        String[][] result = new String[floors][rooms];
        for (int i = 0; i < floors; i++) {
            for (int j = 0; j < rooms; j++) {
                result[i][j] = "";
            }
        }
        return result;
    }

    public static int[] parseStringArrayToInt(String[] input, int threshold) {
        int[] result = new int[input.length];

        //transform over to integer array
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(input[i]);
        }

        //check entire array and set first value to -1 to indicate invalid array
        for (int value : result) {
            if (value < threshold) {
                result[0] = -1;
                return result;
            }
        }

        return result;
    }

    public static boolean searchRoomNames(String[][] hotel, String target) {
        for (int i = 0; i < hotel.length; i++) {
            for (int j = 0; j < hotel[0].length; j++) {
                if (hotel[i][j].equals(target)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void calculatePayment(int floors, int rooms, String[][] names, int[][] costs) {
        int guestCount = 0;
        int totalPaymentCollected = 0;

        //search and tabulate totals
        for (int i = 0; i < floors; i++) {
            for (int j = 0; j < floors; j++) {
                if (!names[i][j].equals("")) {
                    guestCount++;
                    totalPaymentCollected += costs[i][j];
                }
            }
        }
        //Print totals
        System.out.printf("Total payment from %d ", guestCount);
        System.out.print(guestCount > 1 ? "guest " : "guests ");
        System.out.printf(": $%d.00.\n", totalPaymentCollected);
    }

    public static int[][] decrementDays(int[][] array) {
        //create result
        int[][] result = new int[array.length][array[0].length];

        //fill in result
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == 1) {
                    //mark these rooms for removal
                    result[i][j] = -1;
                } else if (array[i][j] > 1) {
                    result[i][j] = array[i][j] - 1;
                }
            }
        }
        return result;
    }
}
