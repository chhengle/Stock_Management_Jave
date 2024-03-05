package view;

import controller.ProductController;
import product.Product;

import java.util.List;
import java.util.Scanner;

public class ProductView {
    private ProductController productController;
    private Scanner scanner;

    public ProductView(ProductController productController) {
        this.productController = productController;
        this.scanner = new Scanner(System.in);
    }

    public void displayProductList(List<Product> productList) {
        if (productList.isEmpty()) {
            System.out.println("No products found.");
            return;
        }
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public Product inputProductDetails() {
        System.out.println("Enter product name:");
        String name = scanner.nextLine();
        System.out.println("Enter unit price:");
        double unitPrice = scanner.nextDouble();
        System.out.println("Enter stock quantity:");
        int stockQuantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        return new Product(name, unitPrice, stockQuantity);
    }

    public int inputProductId() {
        System.out.println("Enter product ID:");
        return scanner.nextInt();
    }

    public String inputProductName() {
        System.out.println("Enter product name:");
        return scanner.nextLine();
    }

    public int inputPageNumber(int totalPages) {
        int pageNumber;
        do {
            System.out.println("Enter page number (1 - " + totalPages + "):");
            pageNumber = scanner.nextInt();
        } while (pageNumber < 1 || pageNumber > totalPages);
        return pageNumber;
    }

    public int inputDisplayRows() {
        System.out.println("Enter number of display rows:");
        return scanner.nextInt();
    }
}
