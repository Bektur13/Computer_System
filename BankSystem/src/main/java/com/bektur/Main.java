package com.bektur;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in); // Reading from System.in
        System.out.println("Enter a number: ");
        int n = reader.nextInt(); // Scans the next token of the input as an int
        System.out.println("Your number is: " + n); // Reading from System.in
        System.out.println("Enter a number: ");
        int n2 = reader.nextInt(); // Scans the next token of the input as an int
        System.out.println("Your number is: " + n2);
        int total = n + n2;
        System.out.println("Your total number is: " + total);
// Once finished
        reader.close();

    }
}