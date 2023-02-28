package org.example.seminar3.hw.ex2;

import org.example.seminar3.hw.ex2.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Product product1 = new Product("Диван", "Россия", 36, 60000,2);
        Product product2 = new Product("Стол", "Венгрия", 12, 25000,1);
        Product product3 = new Product("Шкаф", "США", 21, 48000,1);
        Product product4 = new Product("Кресло", "Канада", 7, 30000,2);
        Product product5 = new Product("Комод", "Италия", 18, 33000,1);


        List <Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);

        System.out.println(productList);
        System.out.println();
        System.out.println("Введите сорт ( 1 или 2):");
        Scanner scanner = new Scanner(System.in);
        Integer changeVar = scanner.nextInt();
        Integer minPrice = Integer.MAX_VALUE;
        String resultCountry = "";

        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getVariety().equals(changeVar) && productList.get(i).getPrice() < minPrice) {
                minPrice = productList.get(i).getPrice();
                resultCountry = productList.get(i).getCountry();
            }
        }
        System.out.println("Country = " + resultCountry);
    }

}
