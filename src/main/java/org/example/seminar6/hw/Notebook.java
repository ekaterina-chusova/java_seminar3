package org.example.seminar6.hw;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Notebook {

    private String brand;
    private String model;
    private Double display;
    private String processor;
    private Integer ram;
    private Integer ssd;
    private String color;
    private Integer price;
    public static List<String> paramsForFilter(){
        List<String> list = new ArrayList<>();
        list.add("brand");
        list.add("display");
        list.add("processor");
        list.add("ram");
        list.add("ssd");
        list.add("color");
        list.add("price");
        return list;
    }
    public String toString() {
        return "\n Ноутбук " + brand + " " + model + ": " +
                "дисплея: " + display +
                ", процессор: " + processor +
                ", ОЗУ: " + ram +
                ", SSD: " + ssd +
                ", цвет: " + color +
                ", цена: " + price;
    }

}

