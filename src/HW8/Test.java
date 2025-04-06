package HW8;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws IOException, MalformedInventoryFileException, CannotFulfillTransactionException {
        File file = new File("src/HW8/Inventory.txt");
        MarketInventoryManager test = MarketInventoryManager.fromFile(file);
        test.buy("A", 1);
        test.buy("B", 1);
        test.saveToFile(file);
    }
}
