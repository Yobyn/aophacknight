package nl.eonics.aophacknight.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.RuntimeJsonMappingException;

@Service
public class ProductService {

    public String getProductById(int id) {
        //System.out.println("Function: getProductById");
        return "Product with ID: " + id;
    }

    public void createProduct(String name) {
        System.out.println("Product created with name: " + name);
        mockDelay();
    }

    public void deleteProduct(int id) {
        System.out.println("Product with ID " + id + " deleted.");
        throw new RuntimeJsonMappingException("Product with ID " + id + " deletetion porcess failed");
    }


    private void mockDelay(){
        try {
            // Generate a random value between 0 and 1000 milliseconds (1 second)
            long sleepTime = (long) (Math.random() * 1000);
            System.out.println("Sleeping for " + sleepTime + " milliseconds");
            
            // Sleep for the random number of milliseconds
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}