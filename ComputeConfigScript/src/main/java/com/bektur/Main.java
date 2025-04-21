package com.bektur;

import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to your config interpreter!");
        Map<String, Integer> configs = new HashMap<>();
        configs.put("nums_users", 100);

        System.out.println("nums_users = " + configs.get("nums_users"));

    }

    private void processLine(String line) {

    }

}