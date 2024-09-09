package nl.eonics.aophacknight.service;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public String getProductById(int id) {
        return "Product with ID: " + id;
    }

    public void createProduct(String name) {
        System.out.println("Product created with name: " + name);
    }

    public void deleteProduct(int id) {
        System.out.println("Product with ID " + id + " deleted.");
    }
}