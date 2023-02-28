package org.example.seminar3.hw.ex1;

import org.example.seminar3.hw.ex1.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        Product product1 = new Product("Яблоки высший", 120, 1);
        Product product2 = new Product("Груши", 90, 1);
        Product product3 = new Product("Манго высший", 300, 2);
        Product product4 = new Product("Апельсин высший", 500, 3);

        List <Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        System.out.println(productList);

        Integer maxPrice = 0;
        String substring = "высший";
        for (int i = 0; i < productList.size(); i++) {
            if ((productList.get(i).getName().toUpperCase().contains(substring.toUpperCase())) && (productList.get(i).getVariety().equals(1) || productList.get(i).getVariety().equals(2))) {
                if (maxPrice < productList.get(i).getPrice()){
                    maxPrice = productList.get(i).getPrice();
                }
            }
        }
        System.out.println("maxPrice = " + maxPrice);
    }

}
