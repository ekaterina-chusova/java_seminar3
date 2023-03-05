package org.example.seminar4.hw.ex2;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        System.out.println(isValid(str));
    }

    public static boolean isValid(String s){
        if (s.length() == 0) return true;
        char [] arrStr = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (int i=0; i < s.length(); i++)
        {
            if(arrStr[i]=='(' || arrStr[i]=='{' || arrStr[i]=='[' )
            {
                stack.push(arrStr[i]);
            }
            if(arrStr[i]==')' ||arrStr[i]=='}' ||arrStr[i]==']')
            {
                if(stack.isEmpty()) return false;
                char pred = stack.pop();
                if((pred=='(' && arrStr[i]==')' ) || (pred=='{' && arrStr[i]=='}' ) ||(pred=='[' && arrStr[i]==']' )  )
                {
                    continue;
                }else
                {
                    return false;
                }
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}

