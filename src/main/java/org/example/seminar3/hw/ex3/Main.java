package org.example.seminar3.hw.ex3;

import org.example.seminar3.hw.ex3.model.Books;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Books books1 = new Books("Маленький принц", "Антуан Де Сент Экзюпери", 100, 2016, 131);
        Books books2 = new Books("Том Сойер", "Марк Твен", 200, 2015, 600);
        Books books3 = new Books("Стихи", "Анна Ахматова", 300, 2020, 283);
        Books books4 = new Books("Руслан и Людмила", "Пушкин", 400, 2009, 333);

        List <Books> booksList = new ArrayList<>();
        booksList.add(books1);
        booksList.add(books2);
        booksList.add(books3);
        booksList.add(books4);
        System.out.println(booksList);

        for (int i = 0; i < booksList.size(); i++) {
            if(isPrime(booksList.get(i).getPages()) && booksList.get(i).getAuthor().toLowerCase().contains("а") && booksList.get(i).getYear() > 2009){
                System.out.println(booksList.get(i).getTitle());
            }
        }
    }

    private static boolean isPrime(Integer countPages) {
        Integer k = 0;
        for (int i = 2; i <= Math.sqrt(countPages); i++) {
            if (countPages % i == 0) {
                k++;
            }
        }
        if (k>0) return false;
        return true;
    }
}