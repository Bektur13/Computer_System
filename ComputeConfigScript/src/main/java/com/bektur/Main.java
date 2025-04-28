package com.bektur;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to your config interpreter!");
        Map<String, Double> configs = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        List<String> lines = new ArrayList<>();
        System.out.println("Enter your config commands: ");
        System.out.println("Enter END to finish!");

        while(true) {
            String input = scanner.nextLine();
            if(input.equals("END")) {
                break;
            }
            lines.add(input);
        }
        for(String line : lines) {
            processLine(line, configs);
        }
    }

    static void processLine(String line, Map<String, Double> configs) {
        if(line.startsWith("config")) {
            // Find name of variable
            int start = line.indexOf("\"") + 1;
            int end = line.indexOf("\"", start);
            String name = line.substring(start, end);

            // Find value of variable
            int equalSum = line.indexOf("=");
            String valueStr = line.substring(equalSum + 1).trim();
            double value = Double.parseDouble(valueStr);

            // Store value in Config
            configs.put(name, value);

            // Print
            System.out.println("Added config: " + name + " = " + value);
        }else if(line.startsWith("update")) {
            // Find a name
            int start = line.indexOf("\"") + 1;
            int end = line.indexOf("\"", start);
            String name = line.substring(start, end);
            // Find a new value
            int equalSum = line.indexOf("=");
            String valueStr = line.substring(equalSum + 1).trim();
            double updatedValue = Double.parseDouble(valueStr);

            // Replace old value on updatedValue
            configs.replace(name, updatedValue);

            // Print
            System.out.println("Updated variable: " + name + " = " + updatedValue);
        }else if(line.startsWith("compute")) {
            int start = line.indexOf("\"") + 1;
            int end = line.indexOf("\"", start);
            String resultName = line.substring(start, end);

            int equalSign = line.indexOf("=");
            String expression = line.substring(equalSign + 1).trim();

            int firstPercent = expression.indexOf("%") + 1;
            int operatorIndex = expression.indexOf(" ", firstPercent);
            String leftVar = expression.substring(firstPercent, operatorIndex);

            char operator = expression.charAt(operatorIndex + 1);

            int secondPercent = expression.indexOf("%", operatorIndex);
            String rightVar = expression.substring(secondPercent + 1);

            double leftValue = configs.get(leftVar);
            double rightValue = configs.get(rightVar);

            double result = 0;
            switch (operator) {
                case '+':
                    result = leftValue + rightValue;
                    break;
                case '-':
                    result = leftValue - rightValue;
                    break;
                case '*':
                    result = leftValue * rightValue;
                    break;
                case '/':
                    result = leftValue / rightValue;
                    break;
            }
            configs.put(resultName, result);

            System.out.println("Computed " + resultName + " = " + result);
        }else if(line.startsWith("show configs")) {
            System.out.println("Here are all configs:");
            for(Map.Entry<String, Double> entry : configs.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
        }
    }

}