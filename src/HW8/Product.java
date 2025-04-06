package HW8;

/**
 * Class defining products for use in inventory files.
 *
 * @author Alex Zhang
 * @version 1.0
 */
public class Product {
    private String id;
    private int buyPrice;
    private int sellPrice;
    private int quantity;

    /**
     * Creates a new product with ID, prices, and quantity.
     *
     * @param id ID of product.
     * @param buyPrice Buy price of product.
     * @param sellPrice Sell price of product.
     * @param quantity Initial amount of the product.
     */
    public Product(String id, int buyPrice, int sellPrice, int quantity) {
        this.id = id;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.quantity = quantity;
    }

    /**
     * Gets buy price of the product.
     *
     * @return Buy price.
     */
    public int getBuyPrice() {
        return buyPrice;
    }

    /**
     * Gets ID of the product.
     *
     * @return ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets sell price of the product.
     *
     * @return sell price.
     */
    public int getSellPrice() {
        return sellPrice;
    }

    /**
     * Gets quantity of the product.
     *
     * @return Quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets product quantity.
     *
     * @param quantity Desired quantity to adjust to.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Represents the product as a CSV line.
     *
     * @return CSV value.
     */
    @Override
    public String toString() {
        return String.format("%s,%d,%d,%d", id, buyPrice, sellPrice, quantity);
    }
}
