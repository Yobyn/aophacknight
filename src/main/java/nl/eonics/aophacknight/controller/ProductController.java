package nl.eonics.aophacknight.controller;

import nl.eonics.aophacknight.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public String getProduct(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public void createProduct(@RequestParam String name) {
        productService.createProduct(name);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }
}