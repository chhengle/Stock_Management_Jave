import controller.ProductController;
import product.Product;
import view.ProductView;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductController productController = new ProductController();
//        initializeData(productController);
        ProductView productView = new ProductView(productController);
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== Product Management System =====");
            System.out.println("1. Display Product List");
            System.out.println("2. Insert Product");
            System.out.println("3. View Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Update Product");
            System.out.println("6. Search by Product Name");
            System.out.println("7. Pagination");
            System.out.println("8. Set Number of Display Rows");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    productView.displayProductList(productController.getProductList());
                    break;
                case 2:
                    Product newProduct = productView.inputProductDetails();
                    productController.insertProduct(newProduct);
                    System.out.println("Product inserted successfully.");
                    break;
                case 3:
                    int viewProductId = productView.inputProductId();
                    Product viewProduct = productController.getProductList().stream()
                            .filter(product -> product.getId() == viewProductId)
                            .findFirst()
                            .orElse(null);
                    if (viewProduct != null) {
                        System.out.println(viewProduct);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 4:
                    int deleteProductId = productView.inputProductId();
                    productController.deleteProduct(deleteProductId);
                    System.out.println("Product deleted successfully.");
                    break;
                case 5:
                    int updateProductId = productView.inputProductId();
                    Product updatedProduct = productView.inputProductDetails();
                    updatedProduct.setId(updateProductId);
                    productController.updateProduct(updatedProduct);
                    System.out.println("Product updated successfully.");
                    break;
                case 6:
                    String searchProductName = productView.inputProductName();
                    List<Product> searchResult = productController.searchByName(searchProductName);
                    productView.displayProductList(Collections.singletonList((Product) searchResult));
                    break;
                case 7:
                    int totalPages = productController.getTotalPages();
                    int pageNumber = productView.inputPageNumber(totalPages);
                    List<Product> pageProducts = productController.getPage(pageNumber);
                    productView.displayProductList(Collections.singletonList((Product) pageProducts));
                    break;
                case 8:
                    int displayRows = productView.inputDisplayRows();
                    productController.setDisplayRows(displayRows);
                    System.out.println("Display rows set to " + displayRows + ".");
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
        private static void initializeData(ProductController productController) {
            // Sample data initialization
            productController.insertProduct(new Product("Product 1", 10.0, 50));
            productController.insertProduct(new Product("Product 2", 20.0, 40));
            productController.insertProduct(new Product("Product 3", 30.0, 30));
            productController.insertProduct(new Product("Product 4", 40.0, 20));
            productController.insertProduct(new Product("Product 5", 50.0, 10));
            productController.insertProduct(new Product("Product 6", 60.0, 5));
            productController.insertProduct(new Product("Product 7", 70.0, 3));
            productController.insertProduct(new Product("Product 8", 80.0, 1));
            productController.insertProduct(new Product("Product 9", 90.0, 2));
            productController.insertProduct(new Product("Product 10", 100.0, 7));
            productController.insertProduct(new Product("Product 11", 110.0, 8));
            productController.insertProduct(new Product("Product 12", 120.0, 6));
            productController.insertProduct(new Product("Product 13", 130.0, 4));
            productController.insertProduct(new Product("Product 14", 140.0, 9));
            productController.insertProduct(new Product("Product 15", 150.0, 12));
    }
}
// Compare this snippet from src/controller/ProductController.java:
// package controller;
