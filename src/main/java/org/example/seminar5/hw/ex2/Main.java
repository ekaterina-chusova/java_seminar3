package org.example.seminar5.hw.ex2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "src/main/java/org/example/seminar5/hw/ex2/text.txt";
        String text = readUsingScanner(fileName);
        System.out.println("Source text:" + text);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите слово:");
        String findName = scanner.nextLine();

        String [] words = text.toLowerCase().replaceAll("\\pP", "").split(" ");

        Map<String, Integer> mapStr = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
                mapStr.putIfAbsent(words[i], 0);
                mapStr.put(words[i], mapStr.get(words[i]) + 1);
            }

        if (mapStr.containsKey(findName.toLowerCase())) System.out.println("Слово <" + findName + "> в тексте встречается: " + mapStr.get(findName.toLowerCase()));

    }

    private static String readUsingScanner(String fileName) throws IOException {
        Scanner scanner = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8.name());
        String data = scanner.useDelimiter("\\A").next();
        scanner.close();
        return data;
    }


}
