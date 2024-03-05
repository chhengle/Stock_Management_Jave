package product;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class Product {
    private static int idCounter = 1;

    private int id;
    private String name;
    private double unitPrice;
    private int stockQuantity;
    private LocalDate importedDate;

    public Product(String name, double unitPrice, int stockQuantity) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException("Invalid name format");
        }
        if (!isValidUnitPrice(unitPrice)) {
            throw new IllegalArgumentException("Invalid unit price");
        }
        if (!isValidStockQuantity(stockQuantity)) {
            throw new IllegalArgumentException("Invalid stock quantity");
        }
        this.id = idCounter++;
        this.name = name;
        this.unitPrice = unitPrice;
        this.stockQuantity = stockQuantity;
        this.importedDate = LocalDate.now();
    }

    private boolean isValidName(String name) {
        // Regular expression for a name consisting of alphabets and spaces only
        String regex = "^[a-zA-Z\\s]+$";
        return Pattern.matches(regex, name);
    }

    private boolean isValidUnitPrice(double unitPrice) {
        // Regular expression for a positive floating point number
        return unitPrice > 0;
    }

    private boolean isValidStockQuantity(int stockQuantity) {
        // Regular expression for a positive integer
        return stockQuantity > 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public LocalDate getImportedDate() {
        return importedDate;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Unit Price: " + unitPrice + ", Stock Quantity: " + stockQuantity
                + ", Imported Date: " + importedDate;
    }

    public void setId(int updateProductId) {
    }
}
