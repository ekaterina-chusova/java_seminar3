package org.example.seminar5.hw.ex1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String str = "Россия идет вперед всей планеты. Планета — это не Россия.";

        LinkedList <String> words = new LinkedList<>(Arrays.asList(str.toLowerCase().replaceAll("\\pP", "").split(" ")));
        for (int i = 0; i < words.size()-1; i++) {
            if (words.get(i).equals("")){
                words.remove(i);
            }
        }
        System.out.println(words);

        Map<String, Integer> mapCh = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            mapCh.putIfAbsent(words.get(i), 0);
            mapCh.put(words.get(i), mapCh.get(words.get(i)) + 1);
        }

        for (Map.Entry<String, Integer> entry :mapCh.entrySet()){
            System.out.println("Слово <" + entry.getKey() + "> встретилось: " + entry.getValue());
        }
    }
}
