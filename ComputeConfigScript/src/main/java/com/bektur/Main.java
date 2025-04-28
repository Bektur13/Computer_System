package com.bektur;

import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to your config interpreter!");
        Map<String, Double> configs = new HashMap<>();
        String[] lines = {
                "config \"num_users\" = 100",
                "config \"request_rate\" = 5.5",
                "config \timeout\" = 30",
                "update \"nums_users\" = 200",
                "update \"request_rate\" = 7.5",
                "compute \"total_requests\" = %num_users * %request_rate",
                "compute \"total_timeout\" = %num_users * %timeout",
                "show configs"
        };
        for(String line : lines) {
            processLine(line, configs);
        }

        System.out.println("nums_users = " + configs.get("nums_users"));

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
            // Find a name of variable
            int start = line.indexOf("\"") + 1;
            int end = line.indexOf("\"", start);
            String name = line.substring(start, end);

            // Find value of variable
            int equalSum = line.indexOf("=");
            String expression = line.substring(equalSum + 1).trim();
            System.out.println(expression);


            System.out.println("This is compute line");
        }else if(line.startsWith("show configs")) {
            System.out.println("This is show configs line");
        }
    }

}