package org.example.seminar3.hw.ex3.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Books {

    private String title;
    private String author;
    private Integer price;
    private Integer year;
    private Integer pages;
}
