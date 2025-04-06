import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//I worked on the homework assignment alone, using only course materials

/**
 * Class reading, writing, and managing inventories.
 *
 * @author Alex Zhang
 * @version 1.0
 */
public class MarketInventoryManager {
    private Product[] products;
    private int money;

    /**
     * Creates a new manager with given products and money.
     *
     * @param products Products in the manager.
     * @param money Money the manager has.
     */
    private MarketInventoryManager(Product[] products, int money) {
        this.products = products;
        this.money = money;
    }

    /**
     * Creates a new MarketInventoryManager from a given CSV file that defines the manager.
     *
     * @param file File to be read from.
     * @return MarketInventoryManager with products and money.
     * @throws IOException Exception for inability to read inventory file.
     * @throws MalformedInventoryFileException Exception for openable but incorrect inventory files.
     */
    public static MarketInventoryManager fromFile(File file) throws IOException, MalformedInventoryFileException {
        //read first line
        Scanner sc = new Scanner(file);
        String[] firstLine;

        try {
            firstLine = sc.nextLine().split(" ");
        } catch (RuntimeException e) {
            throw new MalformedInventoryFileException("Invalid inventory header");
        }

        //Check that header has correct info
        if (firstLine.length != 2 || Integer.parseInt(firstLine[0]) < 0 || Integer.parseInt(firstLine[1]) < 0) {
            throw new MalformedInventoryFileException("Invalid inventory header");
        }

        Product[] products1 = new Product[Integer.parseInt(firstLine[0])];

        //read file
        String[] scannedIDs = new String[Integer.parseInt(firstLine[0])];
        for (int i = 0; i < Integer.parseInt(firstLine[0]); i++) {
            if (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(",");

                //catch product info
                if (line.length != 4 || line[0].isEmpty() || line[0].contains(" ")) {
                    throw new MalformedInventoryFileException("Product information invalid for product " + (i + 1));
                }

                //see if id exists already
                for (int j = 0; j < i; j++) {
                    if (scannedIDs[j].equals(line[0])) {
                        throw new MalformedInventoryFileException("Duplicate product ID: " + line[0]);
                    }
                }
                scannedIDs[i] = line[0];

                //catch other negative values
                for (int j = 1; j < 4; j++) {
                    if (Integer.parseInt(line[j]) < 0) {
                        throw new MalformedInventoryFileException("Product information invalid for product " + (i + 1));
                    }
                }

                products1[i] = new Product(line[0], Integer.parseInt(line[1]),
                        Integer.parseInt(line[2]), Integer.parseInt(line[3]));

            } else {
                //catch incorrect number of products
                throw new MalformedInventoryFileException("Product information incomplete");
            }
        }
        return new MarketInventoryManager(products1, Integer.parseInt(firstLine[1]));
    }

    /**
     * Attempts to buy a product with the given quantity.
     *
     * @param id ID of the product to be bought.
     * @param quantity Quantity of product to buy.
     * @throws CannotFulfillTransactionException Exceptions for impossible transactions.
     */
    public void buy(String id, int quantity) throws CannotFulfillTransactionException {
        if (quantity < 0) {
            throw new CannotFulfillTransactionException("Quantity is Negative");
        }

        for (Product product : this.products) {
            if (product.getId().equals(id)) {
                if (product.getBuyPrice() * quantity > this.money) {
                    throw new CannotFulfillTransactionException("Not enough money to buy");
                }
                product.setQuantity(product.getQuantity() + quantity);
                this.money -= product.getBuyPrice() * quantity;
                return;
            }
        }

        throw new CannotFulfillTransactionException("Product ID not found");
    }

    /**
     * Attempts to sell a given product of the given quantity.
     *
     * @param id ID of the product.
     * @param quantity Amount to sell.
     * @throws CannotFulfillTransactionException Exceptions for impossible transactions.
     */
    public void sell(String id, int quantity) throws CannotFulfillTransactionException {
        if (quantity < 0) {
            throw new CannotFulfillTransactionException("Quantity is negative");
        }

        for (int i = 0; i < this.products.length; i++) {
            if (products[i].getId().equals(id)) {
                if (products[i].getQuantity() < quantity) {
                    throw new CannotFulfillTransactionException("Not enough quantity to sell");
                }
                products[i].setQuantity(products[i].getQuantity() - quantity);
                this.money += products[i].getSellPrice() * quantity;
                return;
            }
        }

        throw new CannotFulfillTransactionException("Product ID not found");
    }


    /**
     * Prints all products the manager is controlling.
     *
     * @return Array of products.
     */
    public String[] marketProducts() {
        String[] output = new String[this.products.length];
        for (int i = 0; i < this.products.length; i++) {
            output[i] = this.products[i].getId();
        }
        return output;
    }

    /**
     * Saves the current inventory into a file.
     *
     * @param file File to save to.
     * @throws IOException for being unable to write to the target file.
     */
    public void saveToFile(File file) throws IOException {
        PrintWriter writer = new PrintWriter(file);
        writer.printf("%d %d\n", this.products.length, this.money);
        for (Product product : products) {
            writer.printf(product.toString() + "\n");
        }
        writer.close();
    }

    /**
     * Creates CLI-like interface to buy and sell products.
     *
     * @param args File to read from.
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.print("Usage: java MarketInventoryManager <inventory-file>");
            System.exit(1);
        }

        File readFile = new File(args[0]);
        try {
            MarketInventoryManager manager = MarketInventoryManager.fromFile(readFile);
            Scanner sc = new Scanner(System.in);

            boolean isRunning = true;
            while (isRunning) {
                System.out.print("> ");
                String[] command = sc.nextLine().split(" ");
                String[] list = manager.marketProducts();

                switch (command[0]) {
                    case "quit":
                        isRunning = false;
                        continue;
                    case "products":
                        if (list.length > 1) {
                            for (int i = 0; i < list.length - 1; i++) {
                                System.out.print(list[i] + ", ");
                            }
                        }
                        System.out.println(list[list.length - 1]);
                        continue;
                    case "buy":
                        try {
                            manager.buy(command[1], Integer.parseInt(command[2]));
                        } catch (CannotFulfillTransactionException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        continue;
                    case "sell":
                        try {
                            manager.sell(command[1], Integer.parseInt(command[2]));
                        } catch (CannotFulfillTransactionException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        continue;
                    default:
                        System.out.println("Error: Invalid command");
                }
            }
            try {
                manager.saveToFile(readFile);
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } catch (MalformedInventoryFileException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("error");
        }
    }
}
