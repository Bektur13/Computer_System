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
                double operator1 = Double.parseDouble(expr[1]);
                double operator2 = Double.parseDouble(expr[2]);
                
                double result = evaluate(operator, operator1, operator2);
                System.out.println(result);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number recieved: " + line);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Input recieved: " + line);
    }

    private static double evaluate(String operator, double operator1, double operator2) throws IllegalAccessException {
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
                if(operator1 % 1 != 0 || operator2 % 1 != 0) {
                    throw new IllegalAccessException("MOD is only supported for integers");
                }
                return operator1 % operator2;
            case "POW":
                return Math.pow(operator1, operator2);
            default:
                throw new UnsupportedOperationException("Operation not supported!");
        }
    }
}
