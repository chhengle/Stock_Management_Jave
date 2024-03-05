package controller;

import product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductController {
    private List<Product> productList;
    private int displayRows = 5; // Default value

    public ProductController() {
        this.productList = new ArrayList<>();
    }

    public void insertProduct(Product product) {
        productList.add(product);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void deleteProduct(int id) {
        productList.removeIf(product -> product.getId() == id);
    }

    public void updateProduct(Product updatedProduct) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == updatedProduct.getId()) {
                productList.set(i, updatedProduct);
                break;
            }
        }
    }

    public List<Product> searchByName(String name) {
        return productList.stream()
                .filter(product -> product.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void setDisplayRows(int displayRows) {
        this.displayRows = displayRows;
    }

    public List<Product> getPage(int pageNum) {
        int startIndex = (pageNum - 1) * displayRows;
        int endIndex = Math.min(startIndex + displayRows, productList.size());
        return productList.subList(startIndex, endIndex);
    }

    public int getTotalPages() {
        return (int) Math.ceil((double) productList.size() / displayRows);
    }
}
