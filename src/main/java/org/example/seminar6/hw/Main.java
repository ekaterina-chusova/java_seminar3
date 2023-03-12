package org.example.seminar6.hw;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<Notebook> catalog = new HashSet<>();

        catalog.add(new Notebook("Huawei", "MateBook D 15 BoD-WDH9",15.6,"Intel Core i5 1135G7",4,256,"серебристый",46900));
        catalog.add(new Notebook("INFINIX","Inbook XL23",14.0,"Intel Core i5 1135G7",16,512,"серый",42900));
        catalog.add(new Notebook("HIPER","G16",16.1,"Intel Core i7 11700",32,1024,"черный",164000));
        catalog.add(new Notebook("MSI","GP66 Leopard 11UG-699XRU",15.6,"Intel Core i7 11800H",16,512,"черный",110000));
        catalog.add(new Notebook("ASUS","A516JP-EJ461",15.6,"Intel Core i7 1065G7",8,512,"серебристый",52000));
        catalog.add(new Notebook("ASUS","Vivobook 15 M1502I",15.6,"AMD Ryzen 5 4600H",16,512,"серебристый",46000));
        catalog.add(new Notebook("Apple","MacBook Air A2337",13.3,"Apple M1 8 core",8,256,"серый",86000));

        Filter userSetting = new Filter(catalog);
        userSetting.start();


    }
}
