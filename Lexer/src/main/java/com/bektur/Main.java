package com.bektur;

import java.io.InputStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Token numberToken = new Token("Number", "5");
        Token plusToken = new Token("PLUS", "+");
        System.out.println(numberToken);
        System.out.println(plusToken);
        System.out.println(numberCheck('6'));
        System.out.println(isOperator('+'));
        String input = "2 + 5";
        for(int i = 0; i < input.length(); i++) {
            input.split("");
            System.out.println("Index:" + i + ":" i);
        }
    }

    private static boolean numberCheck(char character) {
        return character >= '0' && character <= '9';
    }

    public static boolean isOperator(char character) {
        switch (character) {
            case '+':
                return true;
            case '-':
                return true;
            case '*':
                return true;
            case '/':
                return true;
            case '^':
                return true;
        }
        return false;
    }
}
