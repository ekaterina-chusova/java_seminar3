package org.example.seminar4.hw.ex1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    //1)Вывести список на экран в перевернутом виде (без массивов и ArrayList)
    //Пример:
    //1 -> 2->3->4
    //Вывод:
    //4->3->2->1
    public static void main(String[] args) {
        LinkedList <Integer> linkedList = new LinkedList<>(Arrays.asList(1,2,3,4,5,6));
        System.out.println("Source List: " + linkedList);
        System.out.println("Result List:" + reversList(linkedList));
    }

    public static LinkedList <Integer> reversList(LinkedList <Integer> list) {
        for (int i = 0 ; i < list.size()/2 ; i++) {
            Integer temp = list.get(i);
            list.set(i,list.get(list.size()-i-1));
            list.set(list.size()-i-1, temp);
        }
        return list;
    }

}
