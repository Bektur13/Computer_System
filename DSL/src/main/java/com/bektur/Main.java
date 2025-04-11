package com.bektur;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;

        while(!"quit".equalsIgnoreCase(line = scanner.nextLine())) {
            String[] expr = line.split(" ");
            if(expr.length != 3) {
                System.out.println("Invalid Input!");
                continue;
            }
            try {
                String operator = expr[0];
                int operator1 = Integer.parseInt(expr[1]);
                int operator2 = Integer.parseInt(expr[2]);
                
                int result = evaluate(operator, operator1, operator2);
                System.out.println(result);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number recieved: " + line);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Input recieved: " + line);
    }

    private static int evaluate(String operator, int operator1, int operator2) {
        switch (operator) {
            case "ADD":
                return operator1 + operator2;
            case "SUB":
                return operator1 - operator2;
            case "MUL":
                return operator1 * operator2;
            case "DIV":
                if(operator2 == 0) {
                    try {
                        throw new IllegalAccessException("Can't divide by zero");
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
                return operator1 / operator2;
            case "MOD":
                return operator1 % operator2;
            case "POW":
                long result = 1;
                while(operator2 != 0) {
                    result *= operator1;
                    operator2--;
                }
                return (int) result;
            default:
                throw new UnsupportedOperationException("Operation not supported!");
        }
    }
}
