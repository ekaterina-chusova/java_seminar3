package org.example.seminar3.hw.ex2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    private String name;
    private String country;
    private Integer weight;
    private Integer price;
    private Integer variety;
}
